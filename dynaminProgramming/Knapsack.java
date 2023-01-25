import java.util.*;

class Knapsack {
	static int solution(int[] weight, int[] value, int maxWeight, int index, int[][] memory) {
		if(index==weight.length) {
			return 0;
		} else {
			if(memory[index][maxWeight]!=-1) {
				return memory[index][maxWeight];
			}
			if(maxWeight>=weight[index]) {
				memory[index][maxWeight] = Math.max(solution(weight, value, maxWeight, index+1, memory), 
					value[index] + solution(weight, value, maxWeight-weight[index], index+1, memory));
			}else {
				memory[index][maxWeight] = solution(weight, value, maxWeight, index+1, memory);
			}
			return memory[index][maxWeight];
		}
	}

	public static void main(String[] args) {
		int[] weight = {1, 3, 4, 5};
		int[] value = {1, 4, 5, 7};
		int maxWeight = 7;
		int[][] memory = new int[weight.length][maxWeight+1];
		for(int i=0; i<weight.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(weight, value, maxWeight, 0, memory));
		for(int i =0; i<memory.length; i++) {
			System.out.println(Arrays.toString(memory[i]));
		}
	}
}
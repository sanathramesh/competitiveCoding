import java.util.*;

class UnboundedKnapsack {
	static int solution(int[] weight, int[] value, int sum, int[][] memory, int index) {
		if(index==weight.length) {
			return 0;
		}

		if(memory[index][sum]!=-1) {
			return memory[index][sum];
		}

		if(sum>=weight[index]) {
			memory[index][sum] = Math.max(solution(weight, value, sum, memory, index+1), 
				value[index] + solution(weight, value, sum-weight[index], memory, index));
		} else {
			memory[index][sum] = solution(weight, value, sum, memory, index+1);
		}
		return memory[index][sum];
	}

	public static void main(String[] args) {
		int[] weight = {1, 30};
		int sum = 100;
		int[] value = {1, 50};
		int[][] memory = new int[weight.length][sum+1];
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(weight, value, sum , memory, 0));
	}
}
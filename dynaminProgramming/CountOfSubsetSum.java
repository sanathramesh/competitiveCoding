import java.util.*;

class CountOfSubsetSum {
	static int solution(int[] weight, int sum, int index, int[][] memory ) {
		if(sum==0) {
			return 1;
		}
		if(index==weight.length) {
			return 0;
		} 
		if(memory[index][sum]!=-1) {
			return memory[index][sum];
		}
		if(sum>=weight[index]) {
			memory[index][sum] = solution(weight, sum, index+1, memory) 
			+ solution(weight, sum-weight[index], index+1, memory);
		} else {
			memory[index][sum] = solution(weight, sum, index+1, memory); 
		}
		return memory[index][sum];
	}

	public static void main(String[] args) {
		int[] weight = {1, 2, 3, 3};
		int sum = 6;
		int[][] memory = new int[weight.length][sum+1];
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(weight, sum , 0, memory));
	}
}
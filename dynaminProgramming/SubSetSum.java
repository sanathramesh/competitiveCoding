import java.util.*;

class SubSetSum {
	static boolean solution(int[] weight, int sum, int index, Boolean[][] memory) {
		if(sum==0) {
			return true;
		}
		if(index==weight.length) {
			return false;
		} else {
			if(memory[index][sum]!=null) {
				return memory[index][sum];
			}
			if(sum>=weight[index]) {
				memory[index][sum] = solution(weight, sum, index+1, memory) 
				|| solution(weight, sum-weight[index], index+1, memory);
			} else {
				memory[index][sum] = solution(weight, sum , index+1, memory);
			}
			return memory[index][sum];
		}
	}

	public static void main(String[] args) {
		int[] weight = {1, 5, 6, 6};
		int sum = 15;
		Boolean[][] memory = new Boolean[weight.length][sum+1];
		for(int i =0; i<memory.length; i++) {
			Arrays.fill(memory[i], null);
		}
		System.out.println(solution(weight, sum, 0, memory));
		for(int i =0; i<memory.length; i++) {
			System.out.println(Arrays.toString(memory[i]));
		}
	}
}
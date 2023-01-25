import java.util.*;

class EqualSumPartition {
	static Boolean solution(int sum, int index, Boolean[][] memory, int[] weight) {
		if(sum==0) {
			return true;
		}
		if(index==weight.length) {
			return false;
		}
		if(memory[index][sum]!=null) {
			return memory[index][sum];
		}
		if(sum>=weight[index]) {
			memory[index][sum] = solution(sum, index+1, memory, weight) 
			|| solution(sum-weight[index], index+1, memory, weight);
		} else {
			memory[index][sum] = solution(sum, index+1, memory, weight);
		}
		return memory[index][sum];
	}

	public static void main(String[] args) {
		int[] weight = {1, 9, 11, 5};
		int sum = Arrays.stream(weight).sum();
		if(sum%2 != 0) {
			return;
		}
		sum = sum/2;
		Boolean[][] memory = new Boolean[weight.length][sum+1];
		System.out.println(solution(sum, 0, memory, weight));
	}
}
import java.util.*;

class CoinChangeMaxWays {
	static int solution(int[] coins, int sum , int index, int[][] memory) {
		if(index==coins.length) {
			return 0;
		} 
		if(sum==0) {
			return 1;
		}
		if(memory[index][sum]!=-1) {
			return memory[index][sum];
		}
		if(coins[index]<=sum) {
			memory[index][sum] = solution(coins, sum, index+1, memory) + solution(coins, sum-coins[index], index, memory);
		} else {
			memory[index][sum] = solution(coins, sum, index+1, memory);
		}
		return memory[index][sum];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		int sum = 4;
		int[][] memory = new int[coins.length][sum+1];
		for(int i=0; i<coins.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(coins, sum, 0, memory));
	}
}
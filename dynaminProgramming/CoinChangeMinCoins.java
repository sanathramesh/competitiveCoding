import java.util.*;

class CoinChangeMinCoins {

	static int solution(int[] coins, int index, int sum, int[][] memory, int initialSum) {
		if(index == coins.length) {
			return Integer.MAX_VALUE-initialSum;
		}
		if(sum==0) {
			return 0;
		}
		if(memory[index][sum]!=-1) {
			return memory[index][sum];
		}
		if(coins[index]<=sum) {
			memory[index][sum] = Math.min(solution(coins, index+1, sum, memory , initialSum), 
				1+solution(coins, index, sum-coins[index], memory, initialSum));
		} else {
			memory[index][sum] = solution(coins, index+1, sum, memory , initialSum);
		}
		return memory[index][sum];
	}

	public static void main(String[] args) {
		int[] coins = {25, 10, 5};
		int sum = 30;
		int[][] memory = new int[coins.length][sum+1];
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(coins, 0, sum, memory, sum));
		for(int i=0; i<memory.length; i++) {
			System.out.println(Arrays.toString(memory[i]));
		}
	}
}
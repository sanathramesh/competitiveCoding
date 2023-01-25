import java.util.*;

class RodCutting {
	static int solution(int[] rodLength, int[] price, int sum, int[][] memory, int index) {
		if(index==rodLength.length) {
			return 0;
		}
		if(memory[index][sum]!=-1) {
			return memory[index][sum];
		}
		if(rodLength[index]<=sum) {
			memory[index][sum] = Math.max(solution(rodLength, price, sum , memory, index+1), 
				price[index] + solution(rodLength, price, sum-rodLength[index], memory, index));
		} else {
			memory[index][sum] = solution(rodLength, price, sum , memory, index+1);
		}
		return memory[index][sum];

	}

	public static void main(String[] args) {
		int[] rodLength = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int maxLength = rodLength[rodLength.length-1];
		int[][] memory = new int[rodLength.length][maxLength+1];
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(rodLength, price, maxLength, memory, 0));
	}
}
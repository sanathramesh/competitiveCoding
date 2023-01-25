import java.util.*;

class MatrixChainMultiplicaton {
	static int solution(int[] mcm , int start, int end, int[][] memory){
		int sum = Integer.MAX_VALUE;
		if(start==end) {
			return 0;
		}

		if(memory[start][end]!=-1) {
			return memory[start][end];
		}
		for(int i=start; i<end; i++) {
			int temp = solution(mcm, start, i, memory) + mcm[start-1]*mcm[i]*mcm[end] + solution(mcm, i+1, end, memory);
			if(temp<sum) {
				sum = temp;
			}
		}
		
		memory[start][end] = sum;

		return memory[start][end];
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 3};
		int[][] memory = new int[input.length][input.length];
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		System.out.println(solution(input, 1, input.length-1, memory));
		for(int i=0; i<memory.length; i++) {
			System.out.println(Arrays.toString(memory[i]));
		}
	}
}
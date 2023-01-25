import java.util.*;

class RopeCut {
	static void solution(int n) {
		Integer[] memory = new Integer[n+1];
		System.out.println(recur(n, memory));
		System.out.println(Arrays.toString(memory));
	}

	static int recur(int n, Integer[] memory) {
		if(memory[n]!=null) {
			return memory[n];
		}
		if(n==1) {
			return 1;
		}

		int max = 1 ;

		for(int i=1; i<=n-1; i++) {
			int temp = recur(n-i, memory) * recur(i, memory);
			max = Math.max(max, temp);

			max = Math.max(max, i*(n-i));
		}
		memory[n] = max;
		return max;
	}

	public static void main(String[] args) {
		solution(5);
	}
}
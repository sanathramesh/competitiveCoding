import java.util.*;

class MaxJumps {
	static void solution(int[] arr){
		int[] memory = new int[arr.length];
		Arrays.fill(memory, -1);
		int temp = recur(arr, 0, memory);
		if(temp == Integer.MAX_VALUE) {
			temp =  -1;
		} 
		System.out.println(temp);
	}

	static boolean isSafe(int index, int[] arr){
		return index<arr.length ;

	}

	static int recur(int[] arr, int index, int[] memory) {
		if(index==arr.length-1) {
			return 0;
		}
		if(memory[index]!=-1) {
			return memory[index];
		}

		if(arr[index]==0) {
			return Integer.MAX_VALUE;
		}

		int max = Integer.MAX_VALUE;

		for(int i=index+1; i<=index+arr[index]; i++) {
			if(isSafe(i, arr)) {
				int temp = recur(arr, i, memory);
				if(max>temp) {
					max = temp+1;
				}
			}
		}

		memory[index] = max;
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {1, 0,0,0};
		solution(arr);
	}
}
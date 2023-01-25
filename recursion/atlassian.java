import java.util.*;

class atlassian {
	static void solution(int[][] arr) {
		int maxHour = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i][0]>arr[i][1]) {
				arr[i][1] = arr[i][1] + 24;
			}
			if(maxHour<arr[i][1]) {
				maxHour = arr[i][1];
			}
		}

		int[] result = new int[maxHour+1];

		for(int i=0; i<arr.length; i++) {
			for(int j = arr[i][0]; j<=arr[i][1]; j++) {
				result[j] = result[j] + 1;
			}
		}
		System.out.println(Arrays.toString(result));
	}

	public static void main(String[] args) {
		int[][] input = {{1, 2}, {5, 6},{1,5}, {3,1}};
		solution(input);
	}

}
import java.util.*;

class RainWatertrapping {
	static int solution(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		left[0] = arr[0];
		right[arr.length-1] = arr[arr.length-1];
		int i=1;
		while(i<arr.length) {
			left[i] = Math.max(arr[i], left[i-1]);
			i++;
		}

		i = arr.length-2;

		while(i>=0) {
			right[i] = Math.max(arr[i], right[i+1]);
			i--;
		}
		int result = 0;
		for(i=0; i<arr.length; i++) {
			result = result + Math.min(left[i], right[i]) - arr[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(solution(arr));
	}
}
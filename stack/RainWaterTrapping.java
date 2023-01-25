import java.util.*;


class RainWaterTrapping {
	private static int solution(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int n = arr.length;
		left[0] = arr[0];
		right[arr.length-1] = right[arr.length-1];
		for(int i=1; i<n; i++) { 
			left[i] = Math.max(left[i-1], arr[i]);
		};
		right[n-1] = arr[n-1];
		for(int i=n-2; i>=0; i--) {
			right [i] = Math.max(right[i+1], arr[i]);
		};

		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		int totalWaterTrapped = 0;
		for(int i=0; i<n; i++) {
			totalWaterTrapped = totalWaterTrapped + Math.min(left[i], right[i]) - arr[i];
		}

		return totalWaterTrapped;
	}

	public static void main(String[] args) {
		int[] arr = {3, 0, 0, 2, 0, 4};
		int result = solution(arr);
		System.out.println(result);
	}
}
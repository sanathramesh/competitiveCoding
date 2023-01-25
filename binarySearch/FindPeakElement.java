import java.util.*;

class FindPeakElement {
	private static int solution(int[] arr) {
		if(arr.length==0) {
			return -1;
		} 
		if(arr.length==1) {
			return 0;
		}
		return recur(0, arr.length-1, arr);
	}

	private static int recur(int start, int end, int[] arr) {
		// System. out.println(start+" " +end);
		int mid = (start + end)/2;
		if(mid == 0) {
			if(arr[mid]> arr[mid+1]) {
				return mid;
			} else {
				return -1;
			}
		} else if(mid == arr.length-1) {
			if(arr[mid] > arr[mid-1]) {
				return mid;
			} else {
				return -1;
			}
		} else {
			if(arr[mid]>arr[mid-1] && arr[mid+1]< arr[mid]) {
				return mid;
			} else if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
				return recur(mid+1, end, arr);
			} else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]) {
				return recur(start, mid-1, arr);
			} else {
				return Math.max(recur(start, mid-1, arr), recur(mid+1, end, arr));
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {2, 5 ,5, 10, 12};
		int result = solution(arr);
		System.out.println(result);
	}
}
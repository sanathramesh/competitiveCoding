import java.util.*;

class FindAnElementInRotatedSortedArray {
	static int solution(int[] arr, int n) {
		int index = recur(0, arr.length, arr) ;
		if(index==-1) {
			return binarySearch(0, arr.length-1, arr, n);
		} else if(arr[index] > arr[index + 1]) {
			index = index + 1;
		}
		int n1 = binarySearch(index , arr.length-1, arr, n);
		int n2 = binarySearch(0, index-1, arr, n);
		return Math.max(n1, n2);
	}

	static int binarySearch(int start, int end , int[] arr, int n) {
		while (start<=end) {
			int mid = (start + end)/2;
			if(arr[mid] == n) {
				return mid;
			} else if ( arr[mid] > n) {
				end = mid -1;
			} else {
				start = mid + 1;
			}
		}
		return -1;

	}

	static int recur(int start, int end, int[] arr) {
		int mid = (start + end)/2;
		if(mid==0 || mid == arr.length-1 || start>end) {
			return -1;
		} else if(arr[mid-1] <= arr[mid] && arr[mid] <=arr[mid+1]) {
			int n1 = recur(start, mid-1, arr);
			int n2 = recur(mid+1, end, arr);
			return Math.max(n1, n2);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int[] input = {8, 10, 12, 14, 15, 2, 3, 4};
		int result = solution(input, 14);
		System.out.println(result);
	}
}
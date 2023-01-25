import java.util.*;

class SearchInRotatedSortedArray {
	static void solution(int[] arr, int k) {
		int pivot = -1;
		if(arr[0]<=arr[arr.length-1]) {
			pivot = 0;
		} else {
			pivot = findPivot(arr, 0, arr.length-1);
		}

		int result = -1;

		if(k<=arr[arr.length-1]) {
			result = binarySearch(arr, pivot, arr.length-1, k);
		} else {
			result = binarySearch(arr, 0, pivot-1, k);
		}

		System.out.println(pivot + " " + result);

	}

	static int binarySearch(int[] arr, int start, int end, int k) {
		if(start>end) {
			return -1;
		}
		int mid = (start + end)/2;
		if(arr[mid]==k) {
			return mid;
		} else if(arr[mid]>k) {
			return binarySearch(arr, start, mid-1, k);
		} else {
			return binarySearch(arr, mid+1, end, k);
		}
	}

	static int findPivot(int[] arr, int start, int end) {
		int mid = (start + end)/2;
		System.out.println(start + " "  + end);
		if(mid==0 ) {
			if(arr[mid]<=arr[mid+1]){
				return Integer.MIN_VALUE;
			}
			return mid+1;
		} 

		if(start>end) {
			return -1;
		}


		if(mid==arr.length-1) {
			if(arr[mid]>=arr[mid-1]){
				return Integer.MIN_VALUE;
			}
			return mid-1;
		}

		if(arr[mid]>=arr[mid-1] && arr[mid]<=arr[mid+1]) {
			return Math.max(findPivot(arr, start, mid-1), findPivot(arr, mid+1, end));

		} else {
			System.out.println("mid " + mid);
			if(arr[mid]>=arr[mid-1] && arr[mid]>arr[mid+1]) {
				return mid+1;
			} else {
				return mid;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {7,8,1,2,3,4,5,6};
		int k = 2;
		solution(arr, k);
	}
}
import java.util.*;

class NumberOfTimesSortedArrayRotated {
	static int solution(int[] arr) {
		 int result = recur(0, arr.length , arr);
		 if(result == -1) {
		 	return 0;
		 }

		 if(arr[result]< arr[result - 1]) {
		 	return result;
		 } else {
		 	return result+1;
		 }

	}

	static int recur(int start, int end , int[] arr) {
		int mid = (start + end )/2;
		if(mid==0 || start>end) {
			return -1;
		} else if (mid == arr.length-1 ) {
			if(arr[mid]<arr[mid-1]) {
				return mid;
			} else {
				return -1;
			}
		} else if( arr[mid-1] <= arr[mid] && arr[mid]<=arr[mid+1]) {
			int n1 = recur(start, mid-1, arr);
			int n2 = recur(mid+1, end, arr);
			return Math.max(n1, n2);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int[] input = {8, 10, 12, 14, 15, 2, 3, 4, 5};
		int result = solution(input);
		System.out.println(result);
	}

}
class SearchInNearlySortedArray {
	static int solution(int[] arr , int n) {
		return binarySearch(0, arr.length-1, arr, n);
	}

	static int binarySearch(int start, int end, int[] arr, int n) {
		if(start > end) {
			return -1;
		}

		int mid = (start + end)/2;

		if(mid ==0) {
			if(arr[mid] == n) {
				return mid;
			} else if(arr[mid+1] == n) {
				return mid + 1;
			} else {
				return -1;
			}

		} else if(mid == arr.length-1) {
			if(arr[mid] == n) {
				return mid;
			} else if(arr[mid-1] == n) {
				return mid - 1;
			} else {
				return -1;
			}
		} else {
			if(arr[mid] == n) {
				return mid;
			} else if(arr[mid-1] == n) {
				return mid - 1;
			} else if(arr[mid+1] == n){
				return mid + 1;
			}
			int n1 = binarySearch(start, mid-2 , arr, n);
			int n2 = binarySearch(mid+2, end, arr, n);
			return Math.max(n1, n2);

		}
	}

	public static void main(String[] args) {
		int[] input = { 3, 2, 4, 10, 12, 8, 15, 14};
		int n = 8;
		int result = solution(input, n);
		System.out.println(result);
	}
}
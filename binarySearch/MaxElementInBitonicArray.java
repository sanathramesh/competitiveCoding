class MaxElementInBitonicArray {
	static int solution(int[] arr) {
		int start=0, end = arr.length-1;
		while (start<=end) {
			int mid= (start + end)/2;
			if(mid==0) {
				if(arr[mid]>arr[mid+1]) {
					return mid;
				} else {
					return -1;
				}
			} else if(mid==arr.length-1) {
				if(arr[mid]>arr[mid-1]) {
					return mid;
				} else {
					return -1;
				}
			} else {
				if(arr[mid]> arr[mid-1] && arr[mid]>arr[mid+1]) {
					return mid;
				} else if(arr[mid]<arr[mid-1]) {
					start = mid+1;
					
				} else {
					end = mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 0};
		int result = solution(arr);
		System.out.println(result);
	}
}
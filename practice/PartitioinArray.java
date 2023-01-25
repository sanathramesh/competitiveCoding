class PartitionArray {
	static void solution(int[] arr, int k) {

	}

	static int sumOfArray(int[] arr, int start, int end) {
		int sum = 0;
		for(int i=start; i<=end; i++) {
			sum = sum+arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = {};
		int k = 0;
		solution(arr, k);
	}
}
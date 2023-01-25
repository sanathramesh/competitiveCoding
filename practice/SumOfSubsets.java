class SumOfSubSets {
	static boolean solution(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}

		if(sum%2==1) {
			return false;
		}

		sum = sum/2;
		Boolean memory[][] = new Boolean[arr.length][sum+1];
		return recur(sum, arr, 0, memory);
	}

	static boolean recur(int sum , int[] arr, int index, Boolean[][] memory) {
		if(sum==0) {
			return true;
		}
		if(index>=arr.length) {
			return false;
		}
		if(memory[index][sum]!=null) {
			return memory[index][sum];
		}
		boolean result;
		if(sum-arr[index]>=0) {
			result = recur(sum-arr[index], arr, index+1, memory) || recur(sum, arr, index+1, memory);
		} else {
			result = recur(sum, arr, index+1, memory);
		}
		memory[index][sum] = result;
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {1, 5, 11, 5};
		System.out.println(solution(arr));
	}
}
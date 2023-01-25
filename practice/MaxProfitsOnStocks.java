class MaxProfitsOnStocks {


	static int solution(int[] arr, int n) {
		Integer[][] memory = new Integer[arr.length][n+1];
		return recur(arr, n , 0, memory);
	}

	static int recur(int[] arr, int n, int index, Integer[][] memory) {

		// System.out.println(n + " " + index);
		if(n==0 || index>=arr.length) {
			return 0;
		} 

		if(memory[index][n]!=null) {
			return memory[index][n];
		}

		int profit = 0;
		for(int i=index+1; i<arr.length; i++){
			int temp = recur(arr, n-1, i+1, memory)+ arr[i] - arr[index];
			if(temp>profit) {
				profit = temp;
			}
		}
		int temp = recur(arr, n , index+1, memory);
		if(profit<temp) {
			profit = temp;
		}
		memory[index][n] = profit;
		return profit;
	}

	public static void main(String[] args) {
		int[] stocks = {7, 2, 4, 8, 7};
		int n= 2;
		System.out.println(solution(stocks, n));
	}
}
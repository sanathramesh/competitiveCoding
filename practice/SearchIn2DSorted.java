class SearchIn2DSorted {
	static void solution(int[][] arr, int num) {
		int n = arr.length;
		int m = arr[0].length;
		int i=0, j= m-1;
		while(i<n && j>=0) {
			if(arr[i][j]==num) {
				System.out.println(i + " " + j);
				return;
			} else if(arr[i][j]<num) {
				i++;
			} else {
				j--;
			}
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int n = 3;
		solution(arr, n);
	}
}
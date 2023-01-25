import java.util.*;

class NQueens {
	static boolean solution(int n) {
		int[][] arr = new int[n][n];
		boolean result = recur(arr, n, 0);
		for(int i =0 ; i<n ; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(result);
		return result;
	}

	static boolean recur(int[][] arr, int n, int queens) {
		if(queens==n) {
			return true;
		}

		for(int i=0; i<n; i++){
			if(isSafe(queens, i, arr)) {
				arr[queens][i] = 1; 
				if(recur(arr, n, queens+1)) {
					return true;
				} else {
					arr[queens][i] = 0;
				}
			}
		}
		return false;
	}

	static boolean isSafe(int x, int y, int[][] arr) {
		
		for(int i=0; i<x; i++) {
			if(arr[i][y]==1) {
				return false;
			}
		}

		int j = y;
		int i = x;
		while(x>=0 && j>=0 ) {
			if(arr[x][j]==1 ) {
				return false;
			}
			x--;
			j--;
		}

		while(i>=0 && y<arr.length) {
			if(arr[i][y]==1) {
				return false;
			}
			i--;
			y++;
		}
		return true;
	}

	public static void main(String[] args) {
		solution(4);
	}
}
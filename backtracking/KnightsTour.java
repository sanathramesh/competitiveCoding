import java.util.*;

class KnightsTour {
	public static int counter = 0;
	static int[][] solution(int n) {
		int[][] result = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(result[i], -1);
		}
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		result[0][0] = 0;
		recur(result, 0, 0, n, 1, xMove, yMove);
		System.out.println("cycles " + counter);
		return result;
	}

	static boolean isSafe(int x, int y, int[][] arr, int n ) {
		return (x >= 0 && x < n && y >= 0 && y < n
				&& arr[x][y] == -1);
	}

	static boolean recur(int[][] arr , int x, int y, int n, int count, int[] xMove, int[] yMove) {
		counter++;
		if(count==n*n) {
			return true;
		}
		// int[][] nextPositions = generatePositions(x, y);
		for(int i=0; i< 8 ; i++) {
			int next_x = xMove[i] + x;
			int next_y = yMove[i] + y;
			if(isSafe(next_x, next_y, arr, n)){
				arr[next_x][next_y] = count;
				if(recur(arr, next_x, next_y, n, count+1, xMove, yMove)) {
					return true;
				} else {
					arr[next_x][next_y] = -1;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] result = solution(8);
		for(int i=0; i<8; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
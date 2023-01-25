import java.util.*;


class RatInAMaze {
	static void solution(int n, int[][] arr) {
		int[] xMove = {1, -1, 0, 0} ;
		int[] yMove = {0, 0, 1, -1};

		arr[0][0] = 2;
		System.out.println(recur(arr, n, 0, 0, xMove, yMove));
	}

	static boolean isSafe(int x, int y, int[][] arr) {
		if (x<arr.length && x>=0 && y<arr.length && y>=0 && arr[x][y]==1){
			return true;
		} else {
			return false;
		}
	}

	static boolean recur(int[][] arr, int n , int x, int y, int[] xMove, int[] yMove ) {
		if(x==n-1 && y==n-1) {
			return true;
		}
		
		for(int i=0; i<4; i++) {
			int nextX = x+xMove[i];
			int nextY = y+yMove[i];
			if(isSafe(nextX, nextY, arr)) {
				arr[nextX][nextY] = 2; 
				if(recur(arr, n , nextX, nextY, xMove, yMove)) {
					return true;
				} else {
					arr[nextX][nextY] = 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        solution(maze.length, maze);

        for(int i = 0; i<maze.length; i++) {
        	System.out.println(Arrays.toString(maze[i]));
        }
	}
}
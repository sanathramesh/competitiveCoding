import java.util.*;

class NumberOfIslands {
	static void solution(int[][] arr) {
		Integer[][] visited = new Integer[arr.length][arr[0].length];
		int totalIslands = 0;
		int[] xMove = {1, 1, 1, 0, 0, -1 , -1, -1};
		int[] yMove = {1, -1, 0, 1, -1, 1, -1, 0};
		Stack<Integer[]> s = new Stack<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==1 && visited[i][j]==null) {
					totalIslands++;
					s.push(new Integer[]{i, j});
					dfs(s, visited, arr, xMove, yMove);
				}
			}
		}
		System.out.println(totalIslands);
	}

	static void dfs(Stack<Integer[]> s, Integer[][] visited, int[][] arr, int[] xMove, int[] yMove) {
		while(!s.isEmpty()) {
			Integer[] temp = s.pop();
			visited[temp[0]][temp[1]] = 1;
			for(int i=0; i<8; i++) {
				int nextX = xMove[i] + temp[0];
				int nextY = yMove[i] + temp[1];
				if(isSafe(nextX, nextY, arr, visited)) {
					s.push(new Integer[]{nextX, nextY});
				}
			}
		}
	}

	static boolean isSafe(int x, int y, int[][] arr, Integer[][] visited) {
		return (x<arr.length && y<arr[0].length && x>=0 && y>=0 && visited[x][y]==null && arr[x][y]==1);
	} 

	public static void main(String[] args) {
		int[][] arr = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
		solution(arr);
	}
}
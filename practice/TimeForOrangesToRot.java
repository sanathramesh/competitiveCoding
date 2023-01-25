import java.util.*;

class TempNode {
	int x; 
	int y;
	int time;
	public TempNode(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

class TimeForOrangesToRot {
	static int maxTime = 0;
	static int solution(int[][] arr) {
		Queue<TempNode> queue = new LinkedList<TempNode>();
		int[] xMove = {1, -1, 0, 0};
		int[] yMove = {0, 0, 1, -1};
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==2) {
					queue.add(new TempNode(i, j, 0));
				}
			}
		}
		recur(arr, queue, xMove, yMove);
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {

				if(arr[i][j]==1) {
					return -1;
				}
			}
		}
		return maxTime;
	}

	static boolean isSafe(int nextX, int nextY, int[][] arr) {
		if(nextX>=0 && nextY>=0 && nextX<arr.length && nextY<arr[0].length && arr[nextX][nextY]==1) {
			return true;
		}
		return false;
	}

	static void recur(int[][] arr, Queue<TempNode> queue, int[] xMove, int[] yMove) {
		if(queue.isEmpty()) {
			return;
		} 

		TempNode current = queue.remove();
		if(current.time>maxTime) {
			maxTime = current.time;
		}
		for(int i=0; i<4; i++) {
			int nextX = xMove[i] + current.x;
			int nextY = yMove[i] + current.y;
			if(isSafe(nextX, nextY, arr)) {
				arr[nextX][nextY] = 2;
				queue.add(new TempNode(nextX, nextY, current.time+1));
			}
		}
		recur(arr, queue, xMove, yMove);

	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,2},{0,1,2},{2,1,1}};
		System.out.println(solution(arr));
	}
}
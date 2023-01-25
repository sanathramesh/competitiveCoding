class RobotDest {
	static void solution(int[][] arr) {
		int[] xMove = {1, 0};
		int[] yMove = {0, 1};
		System.out.println(recur(arr, 0, 0, xMove, yMove));
	}

	static boolean isSafe(int x, int y, int[][] arr) {
		return (x<arr.length && y<arr[0].length);
	}

	static int recur(int[][] arr, int x, int y, int[] xMove, int[] yMove) {
		if(x==arr.length-1 && y ==arr[0].length-1) {
			return 1;
		}
		int count = 0;
		for(int i=0; i<2; i++) {
			int nextX = xMove[i] + x;
			int nextY = yMove[i] + y;
			if(isSafe(nextX, nextY, arr)) {
				count = count + recur(arr, nextX, nextY, xMove, yMove);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] arr = new int[3][7];
		solution(arr);
	}
}
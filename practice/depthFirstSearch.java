import java.util.*;

class depthFirstSearch {
	static void solution(int[][] arr) {
		int[] visited = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		visited[0] = 1;
		while(!stack.isEmpty()) {
			int current = stack.pop();
			System.out.println(current);
			for(int i=0; i<arr.length; i++) {
				if(arr[current][i]==1 && visited[i]!=1) {
					stack.push(i);
					visited[i] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,1,1,1},{1,0,2,0,0},{1,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0}};
		solution(arr);

	}
}
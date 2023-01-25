import java.util.*;

class DepthFirstRecur {
	static void solution(int[][] arr) {
		int[] visited = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		recur(arr, stack, visited);
	}

	static void recur(int[][] arr, Stack<Integer> stack, int[] visited) {
		if(stack.isEmpty()) {
			return ;
		}

		int current = stack.pop();
		if(visited[current]==1) {
			return;
		}
		visited[current] = 1;
		System.out.println(current);
		for(int i=0; i<arr.length; i++) {
			if(arr[current][i]==1 && visited[i]!=1) {
				stack.push(i);
			}
		}
		recur(arr, stack, visited);
	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,1,1,1},{1,0,1,1,0},{1,1,0,0,0},{1,1,0,0,0},{1,0,0,0,0}};
		solution(arr);
	}
}
import java.util.*;

class dfs {
	static void dfs(int[][] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[arr.length];

		stack.push(0);
		List<Integer> result = new ArrayList<>();
		recur(stack, arr, visited, result);
		System.out.println(result);
	}

	static void recur(Stack<Integer> stack, int[][] arr, int[] visited, List<Integer> result) {
		if(stack.isEmpty()) {
			return;
		}
		int current = stack.pop();

		if(visited[current]==1) {
			return ;
		}
		visited[current] = 1;
		result.add(current);
		// System.out.println(current);
		for(int i=0; i<arr.length; i++) {
			if(arr[current][i]==1 && visited[i]==0) {
				stack.push(i);
			}
		}
		recur(stack, arr, visited, result);
	}

	static void dfsIterative(int[][] arr) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		stack.push(0);
		int[] visited= new int[arr.length];
		while(!stack.isEmpty()) {
			int current = stack.pop();
			if(visited[current]==1) {
				continue;
			}
			visited[current] = 1;
			result.add(current);
			for(int i=0; i<arr.length; i++) {
				if(visited[i]==0 && arr[current][i]==1) {
					stack.push(i);
				}
			}
		}
		System.out.println(result);

	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,1,0,0},{0,0,0,1,0}, {0,0,0,0,1}, {0,0,0,0,0}, {0,0,0,0,0}};
		dfs(arr);
		dfsIterative(arr);
	}
}
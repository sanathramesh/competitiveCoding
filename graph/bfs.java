import java.util.*;

class bfs {
	static void bfs(int[][] arr) {
		Queue<Integer>  queue = new LinkedList<>();
		queue.add(0);
		int[] visited = new int[arr.length];
		List<Integer> result = new ArrayList<>();

		recur(result, queue, visited, arr);
		System.out.println(result);
	}

	static void recur(List<Integer> result, Queue<Integer> queue, int[] visited, int[][] arr) {
		if(queue.isEmpty()) {
			return;
		}
		int current = queue.remove();
		if(visited[current]==1) {
			return;
		}
		visited[current] = 1;
		result.add(current);
		for(int i=0; i<arr.length; i++) {
			if(arr[current][i]==1 && visited[i]==0) {
				queue.add(i);
			}
		}
		recur(result, queue, visited, arr);
	}

	static void bfsIterative(int[][] arr) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int[] visited = new int[arr.length];
		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()) {
			int current = queue.remove();
			if(visited[current]==1) {
				continue;
			}
			visited[current] = 1;
			result.add(current);
			for(int i=0; i<arr.length; i++) {
				if(arr[current][i]==1 && visited[i]==0) {
					queue.add(i);
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,1,0,0},{0,0,0,1,0},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
		bfs(arr);
		bfsIterative(arr);
	}
}
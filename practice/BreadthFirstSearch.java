import java.util.*;

class BreadthFirstSearch {
	static void solution(int[][] arr) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int[] visited = new int[arr.length];
		recur(arr, visited, queue);

	}

	static void recur(int[][] arr, int[] visited, Queue<Integer> queue) {
		if(queue.isEmpty()) {
			return ;
		}

		int current = queue.remove();
		if(visited[current]==1) {
			return ;
		}
		System.out.println(current);
		visited[current] = 1;
		for(int i=0; i<arr.length; i++) {
			if(arr[current][i]==1 && visited[i]==0) {
				queue.add(i);
			}
		}
		recur(arr, visited, queue);
	}

	public static void main(String[] args) {
		int[][] arr = {{0,0,1,1,1},{0,0,1,1,0},{1,1,0,0,0},{1,1,0,0,0},{1,0,0,0,0}};
		solution(arr);
	}
}
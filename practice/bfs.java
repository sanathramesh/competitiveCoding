import java.util.*;

class bfs {
	static void solution(int[][] adj) {
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> s = new HashSet<>();
		q.add(0);
		bfs(adj, q, s);
	}

	static void bfs(int[][] adj, Queue<Integer> q, Set<Integer> s) {
		if(q.isEmpty()) {
			return;
		}

		int current = q.remove();
		s.add(current);
		System.out.print(current + " ");
		for(int i=0; i<adj.length; i++) {
			if(adj[current][i]==1 && !s.contains(i)) {
				q.add(i);
			}
		}
		bfs(adj, q, s);
	}

	public static void main(String[] args){
		int[][] arr = {{1, 0, 0, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
		solution(arr);
	}
}
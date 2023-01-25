import java.util.*;

class dfs {
	static void solution(int[][] adj) {
		Stack<Integer> s = new Stack<>();
		Set<Integer> set = new HashSet<>();
		s.push(0);
		bfs(adj, s, set);

	}

	static void bfs (int[][] adj, Stack<Integer> s, Set<Integer> set) {
		if(s.isEmpty()) {
			return;
		}

		int current = s.pop();
		set.add(current);
		System.out.print(current + " ");
		for(int i=0; i<adj.length; i++) {
			if(adj[current][i]==1 & !set.contains(i)) {
				s.push(i);
				bfs(adj, s, set);
			}
		}
	}

	public static void main(String[] args){
		int[][] adj = {{1, 0, 0, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
		solution(adj);
	}
}
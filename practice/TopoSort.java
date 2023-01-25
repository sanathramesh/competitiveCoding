import java.util.*;

class TopoSort {
	static void solution(int[][] adj){
		boolean[] visited = new boolean[adj.length];
		Stack<Integer> s = new Stack<>();
		s.push(0);
		dfsVariation(s, visited, adj);
	}

	static void dfsVariation(Stack<Integer> s, boolean[] visited, int[][] adj) {
		if(s.isEmpty()) {
			return;
		}
		int current = s.pop();
		visited[current] = true;
		for(int i=0; i<adj.length; i++) {
			if(adj[current][i]==1 && visited[i]==false) {
				s.push(i);
				dfsVariation(s, visited, adj);
			}
		}
		
		System.out.print(" " + current);
	}

	public static void main(String[] args) {
		int[][] G = { { 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 },
        { 0, 0, 0, 1, 0 } };
        solution(G);
	}
}
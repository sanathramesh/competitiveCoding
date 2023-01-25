import java.util.*;

class HamiltonianCycle {
	static void solution(int[][] adj){
		boolean[] visited = new boolean[adj.length];
		visited[0] = true;
		int currentEdges = 0;
		System.out.println(recur(adj, currentEdges, 0, visited));
	}

	static boolean recur(int[][] adj, int currentEdges, int currentNode, boolean[] visited) {
		System.out.println(currentEdges + " " + currentNode);
		if(currentEdges==adj.length ) {
			if( currentNode==0)
				return true;
			else 
				return false;
		}
		boolean result = false;

		for(int i=0; i<adj.length; i++) {
			if(adj[currentNode][i]==1) {
				visited[i] = true;
				result = result || recur(adj, currentEdges+1, i, visited);
				visited[i] = false;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] G = { { 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 },
		{ 0, 1, 0, 1, 0 } };
		solution(G);	
    }
}
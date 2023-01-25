class HamiltonianPath {
	static void solution(int[][] adj){
		boolean[] visited = new boolean[adj.length];
		visited[0] = true;
		int currentEdges = 0;
		recur(adj, currentEdges, currentNode, visited);
	}

	boolean recur(int[][] adj, int currentEdges, int currentNode, boolean[] visited) {
		if(currentEdges==adj.length ) {
			if( currentNode=0)
				return true;
			else 
				return false;
		}

		if(visited[currentNode]==true) {
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

	public static void main(String[] args) {}
}
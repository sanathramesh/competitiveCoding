class prims {

	static void solution(int[][] adj) {
		boolean[] visited = new boolean[adj.length];

		visited[0] = true;

		int edges = 0;
		while(edges<adj.length-1) {
			int minEdge = Integer.MAX_VALUE;
			int x = -1;
			int y = -1;
			for(int i=0; i<adj.length; i++) {
				if(visited[i]==true) {
					for(int j=0; j<adj.length; j++) {
						if(visited[j]==false && minEdge>adj[i][j] && adj[i][j]!=0) {
							minEdge = adj[i][j];
							x = i;
							y = j;
						}
					}
				}
			}
			System.out.println(x + "-" + y + " " + adj[x][y]);
			edges++;
			visited[y] = true;
		}
	}

	public static void main(String[] args) {
		int[][] adj = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };
        solution(adj);
	}
}
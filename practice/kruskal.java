class kruskal {
	static void solution(int[][] adj){
		int edges = 0;
		boolean[] visited = new boolean[adj.length];

		while(edges<adj.length-1) {
			int x = -1, y=-1, minEdge = Integer.MAX_VALUE;
			for(int i=0; i<adj.length; i++) {
				for(int j=0; j<adj.length; j++) {
					if(adj[i][j]<minEdge && (visited[i]!=true || visited[j]!=true) && adj[i][j]!=0) {
						minEdge = adj[i][j];
						x = i;
						y = j;
					}
				}
			}
			edges++;
			if(x!=-1 && y!=-1){
				visited[x] = true;
				visited[y] = true;
				System.out.println(x + "-" + y + " " + adj[x][y]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] adj = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };
        solution(adj);
	}
}
import java.util.*;

class GraphColoring {
	static void solution(int[][] adj, int colors){
		int[] color = new int[adj.length];
		Arrays.fill(color, -1);
		for(int i=0; i<adj.length; i++) {
			int[] available = new int[colors];
			for(int j=0; j<adj.length; j++) {
				if(adj[i][j]==1 && color[j]!=-1) {
					available[color[j]] = 1;
				}
			}

			int currentColor = -1;
			for(int j=0; j<colors; j++) {
				if(available[j]==0) {
					currentColor = j;
					break;
				}
			}

			color[i] = currentColor;
		}
		System.out.println(Arrays.toString(color));
	}

	public static void main(String[] args) {
		int[][] adj = {{0, 0, 1, 1}, {0, 0, 1, 1}, {1, 1, 0, 0}, {1, 1, 0, 0}};
		int colors = 5;
		solution(adj, colors);
	}
}
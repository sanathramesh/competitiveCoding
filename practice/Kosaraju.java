import java.util.*;

class Kosaraju {
	static void solution(int[][] adj){
		Set<Integer> s = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<adj.length; i++) {
			if(!s.contains(i)) {
				dfs(adj, q, i, s);
			}
		}
		List<List<Integer>> result = new ArrayList<>();

		s = new HashSet<>();

		for(int i=0; i<adj.length; i++) {
			for(int j=0; j<adj[0].length; j++) {
				if(j<adj[0].length/2) {
					arr[i][j]= arr[j][i];
				}
			}
		}

		while(!q.isEmpty()) {
			int temp = q.remove();
			if(!s.contains(temp)) {
				kos(temp, s, adj, result, new ArrayList<>());
			}
		}



	}

	static void kos(int temp, Set<Integer> s, int[][] adj, List<List<Integer>> result, List<Integer> current) {
		s.add(temp);
		for(int i=0; i<adj.length; i++) {
			if(adj[temp][i]==1 && !s.contains(i)) {
				current.add(i);
				kos(i, s, adj, result, current);
			}
		}
	}

	static void dfs(int[][] adj, Queue<Integer> q, int n, Set<Integer> s) {
		System.out.println(n + " " + s + " " + q.toString());
		s.add(n);
		for(int i=0; i<adj.length; i++) {
			if(adj[n][i]==1 && !s.contains(i)) {
				dfs(adj, q, i, s);
			}
		}
		q.add(n);
	}

	public static void main(String[] args){
		int[][] adj = {{0,0,1,1,0}, {1,0,0,0,0}, {0,1,0,0,0}, {0,0,0,0,1}, {0,0,0,0,0}};
		solution(adj);
	}

}
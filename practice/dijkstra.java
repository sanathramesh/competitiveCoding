import java.util.*;

class dijkstra {
	static void solution(int[][] adj, int start){
		int[] distance = new int[adj.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<adj.length; i++) {
			int minIndex = findMinIndex(set, distance);
			for(int j=0; j<adj.length; j++) {
				if(adj[minIndex][j]!=-1 && !set.contains(j)) {
					if(distance[minIndex] + adj[minIndex][j] < distance[j]) {
						distance[j] = distance[minIndex] + adj[minIndex][j];
					}
				}
			}
			set.add(minIndex);
		}

		System.out.println(Arrays.toString(distance));
	}

	static int findMinIndex(Set<Integer> set, int[] distance) {
		int result = -1;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<distance.length; i++) {
			if(min>distance[i] && !set.contains(i)) {
				min = distance[i];
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args){
		int[][] adj = new int[][] { 
			{ -1, 3, -1, -1, -1, -1, -1, 7, -1 },  
			{ 3, -1, 7, -1, -1, -1, -1, 10, 4 },  
			{ -1, 7, -1, 6, -1, 2, -1, -1, 1 },  
			{ -1, -1, 6, -1, 8, 13, -1, -1, 3 },  
			{ -1, -1, -1, 8, -1, 9, -1, -1, -1 },  
			{ -1, -1, 2, 13, 9, -1, 4, -1, 5 },  
			{ -1, -1, -1, -1, -1, 4, -1, 2, 5 },  
			{ 7, 10, -1, -1, -1, -1, 2, -1, 6 },  
			{ -1, 4, 1, 3, -1, 5, 5, 6, -1 } };
		solution(adj, 0);
	}
}
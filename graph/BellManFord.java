import java.util.*;

class BellManFord {
	static void solution(List<Integer[]> edges, int v) {
		int j=0; 
		Integer[] distance = new Integer[v];
		distance[0] = 0;
		while(j<v-1) {
			for(int i=0; i<edges.size(); i++) {
				if(distance[edges.get(i)[0]]!=null) {
					if(distance[edges.get(i)[1]]==null) {
						distance[edges.get(i)[1]] = distance[edges.get(i)[0]] + edges.get(i)[2];
					} else if(distance[edges.get(i)[0]] + edges.get(i)[2]<distance[edges.get(i)[0]]) {
						distance[edges.get(i)[1]] = distance[edges.get(i)[0]] + edges.get(i)[2];
					}
				}
			}
			j++;
		}
		System.out.println(Arrays.toString(distance));
	} 

	public static void main(String[] args) {
		int[][] arr = {{0,1,2,0,0,0}, {0,0,0,2,1,0}, {0,0,0,0,1,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
		List<Integer[]> edges = new ArrayList<>();
		edges.add(new Integer[]{0, 1, 1});
		edges.add(new Integer[]{0, 2, 2});
		edges.add(new Integer[]{1, 4, 1});
		edges.add(new Integer[]{1, 3, 2});
		edges.add(new Integer[]{2, 4, 1});
		solution(edges, 6);
	}
}
import java.util.*;

class GraphCycle {
	static boolean solution(int v, int[][] edges) {
		Set<Integer> set = new HashSet<>();
		Stack<Integer> s = new Stack<>();
		Set<String> edgeSet = new HashSet<>();
		s.push(0);
		while(!s.isEmpty()) {
			int temp = s.pop();
			if(set.contains(temp)) {
				return true;
			}
			for(int i=0; i<v; i++) {

				if(edges[temp][i]==1 && !edgeSet.contains(String.valueOf(i) + "|" + String.valueOf(temp)) && 
					!edgeSet.contains(String.valueOf(temp) + "|" + String.valueOf(i))) {
					s.push(i);
					edgeSet.add(String.valueOf(i) + "|" + String.valueOf(temp));
					edgeSet.puash(String.valueOf(temp) + "|" + String.valueOf(i));
				}
			}
			set.add(temp);
		}
		return false;
	}

	public static void main(String[] args) {
		int V = 5; 
		int[][] edges = {{0,1,0,0,0}, {1, 0, 1, 0,1}, {0,1,0,1,0}, {0,0,1,0,1}, {0,1,0,1,0}};
		System.out.println(solution(V, edges));
	}
}
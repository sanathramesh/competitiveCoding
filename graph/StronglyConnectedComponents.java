import java.util.*;

class StronglyConnectedComponents {
	static void solution(int[][] arr) {
		List<List<Integer>> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		Queue<Integer> dfs = new LinkedList<>();
		int[] visited = new int[arr.length];
		while(!stack.isEmpty()) {
			int current = stack.pop();
			if(visited[current]==1) {
				continue;
			}
			visited[current] = 1;
			dfs.add(current);
			for(int i=0; i<arr.length; i++) {
				if(arr[current][i]==1 && visited[i]==0) {
					stack.push(i);
				}
			}
		}
		System.out.println(dfs);
		visited = new int[arr.length];
		for(int i=0; i<arr.length;  i++) {
			for(int j=i; j<arr.length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		while(dfs.size()>0) {
			List<Integer> components = new ArrayList<>();
			int current = dfs.remove();
			if(visited[current]==1) {
				continue;
			}
			stack.clear();
			stack.push(current);
			while(!stack.isEmpty()) {
				int temp = stack.pop();
				if(visited[temp]==1) {
					continue;
				}
				components.add(temp);
				visited[temp] = 1;
				for(int i=0; i<arr.length; i++) {
					if(arr[temp][i]==1 && visited[i]!=1) {
						stack.push(i);
					}
				}
			}

			result.add(components);

		}

		System.out.println(result);
	}


	public static void main(String[] args) {
		int[][] arr = {{0,1,0,0},{0,0,1,1},{1,0,0,0},{0,0,0,0}};
		solution(arr);
	}
}
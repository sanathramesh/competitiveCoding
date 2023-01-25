import java.util.*;

class AllPermutations {
	static void solution(int[] arr) {
		ArrayList<int[]> result = new ArrayList<>();
		int[] visited = new int[arr.length];
		int[] current = new int[arr.length];
		recur(arr, result, current, 0, visited) ;

		for(int[] s : result) {
			System.out.println(Arrays.toString(s));
		}
	}

	static void recur(int[] arr, ArrayList<int[]> result, int[] current, int index, int[] visited) {
		if (index==arr.length) {
			result.add(current);
			return;
		}

		for(int i=0; i<visited.length; i++) {
			if(visited[i]==0) {
				current[index] = arr[i];
				visited[i] = 1;
				recur(arr, result, current.clone(), index+1, visited);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		solution(arr);
	}
}
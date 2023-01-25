import java.util.*;

class dijkstra {
	static void solution(int[][] arr) {
		int[] distance = new int[arr.length];
		int[] visited = new int[arr.length];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;

		for(int i=0; i<arr.length; i++) {
			int index = findMin(visited, distance);
			System.out.println(index);
			if(index == -1) {
				break;
			}
			visited[index] = 1;
			for(int j=0; j<arr.length; j++) {
				if(arr[index][j]!=0 && visited[j]!=1) {
					if(arr[index][j]+distance[index]<distance[j]) {
						distance[j] = arr[index][j] + distance[index];
					}
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}

	static int findMin(int[] visited, int[] distance) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0; i<visited.length; i++) {
			if(visited[i]!=1 && distance[i]<min) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,2,0,0,0}, {0,0,0,2,1,0}, {0,0,0,0,1,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
		solution(arr);
	}
}
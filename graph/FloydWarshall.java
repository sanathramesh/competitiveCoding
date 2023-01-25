import java.util.*;

class FLoydWarshall {
	static void solution(int[][] arr) {
		for(int v=0; v<arr.length; v++) {
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i][v] + arr[v][j]<arr[i][j]) {
						arr[i][j] = arr[i][v] + arr[v][j];
					}
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public static void main(String[] args) {
		int[][] arr = {{0,1,2,0,0,0}, {0,0,0,2,1,0}, {0,0,0,0,1,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]==0) {
					arr[i][j] = 999;
				}
			}
		}
		solution(arr);
	}
}
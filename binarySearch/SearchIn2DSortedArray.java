import java.util.*;

class SearchIn2DArray {
	static int[] solution(int[][] arr, int n){
		int[] result = {-1, -1};
		int rows = arr.length-1;
		if(rows==0 ) { 
			return result;
		} else {
			int columns = arr[0].length-1 ;
			int j = columns; int i = 0;
			while(i<=rows && j>=0) {
				System.out.println(i + " " + j);
				if(arr[i][j]==n) {
					result[0] = i;
					result[1] = j;
					break;
				} else if(arr[i][j]>n) {
					j--;
				} else {
					i++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3, 4, 5} , {3, 4, 7, 11, 13}, {5, 6, 8, 12, 15}};
		int[] result = solution(arr,15);
		System.out.println(Arrays.toString(result));
	}
}
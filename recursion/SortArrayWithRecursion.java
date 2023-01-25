import java.util.*;

class SortArrayWithRecursion {
	static void solution(int[] arr, int n) {
		int minElement = n;
		if(n==arr.length) {
			return;
		}
		for(int i=n+1; i<arr.length; i++) {
			if(arr[minElement]>arr[i]) {
				minElement = i;
			}
		}

		int temp = arr[minElement];
		arr[minElement] = arr[n];
		arr[n] = temp;
		solution(arr, n+1);
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 1, 0, -1 , 5};
		solution(arr, 0);
		System.out.println(Arrays.toString(arr));
	}
}
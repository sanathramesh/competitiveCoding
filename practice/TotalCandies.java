import java.util.*;

class TotalCandies {
	static int[] solution(int[] arr){
		PriorityQueue<int[]> queue = new PriorityQueue<>(new ArrayComparator());

		for(int i=0; i<arr.length; i++) {
			queue.add(new int[]{arr[i], i});
		}

		int[] result = new int[arr.length];

		while(!queue.isEmpty()) {
			int[] temp = queue.remove();
			if(temp[1]==0) {
				if(arr[1]!=0) {
					if(arr[0]>arr[1]) {
						result[0] = result[1] +1;
					} else {
						result[0] = 1;
					}
				}
			} else if(temp[1]==arr.length-1) {
				if(arr[arr.length-2]<arr[arr.length-1]) {
					result[arr.length-1] = result[arr.length-2] +1;
				} else {
					result[arr.length-1] = 1;
				}
			} else {
				result[temp[1]] = Math.max(result[temp[1]-1] , result[temp[1]+1]) +1;
			}
		}
		return result;
	}

	static class ArrayComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] arr1, int[] arr2) {
			if(arr1[0]>arr2[0]) {
				return 1;
			} else if(arr1[0]==arr2[0]) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] arg) {
		System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 1})));
	}
}
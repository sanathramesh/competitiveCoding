import java.util.*;

class KClosestNumbers {

	static class ArrayComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] first, int[] second) {
			if(first[0]>second[0]) {
				return -1;
			} else if(first[0]==second[0]) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	static int[] solution(int[] arr, int k, int n ) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new ArrayComparator());
		for(int i=0; i<arr.length; i++) {
			int[] toInsert = {Math.abs(arr[i]-n), i};
			minHeap.add(toInsert);
			if(minHeap.size()==k+1) {
				minHeap.remove();
			}
		}

		int[] result = new int[k];
		int i = 0;
		while(minHeap.size()>0) {
			result[i] = arr[minHeap.remove()[1]];
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {5, 6, 7, 8, 9};
		int[] result = solution(arr, 3, 7);
		System.out.println(Arrays.toString(result));
	}
}
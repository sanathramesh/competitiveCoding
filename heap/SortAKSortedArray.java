import java.util.*;

class SortAKSortedArray {
	static int[] solution(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int i =0;
		int[] result = new int[arr.length];
		while(i<=k) {
			minHeap.add(arr[i]);
			i++;
		}
		int j=0;
		for(i=k+1; i<arr.length;i++,j++) {
			if(minHeap.size()==k+1) {
				result[j] = minHeap.remove();

			} 
			minHeap.add(arr[i]);
		}
		while(minHeap.size()>0) {
			result[j] = minHeap.remove();
			j++;
		}
		return result; 
	}

	public static void main(String[] args) {
		int[] arr = {6, 5, 3, 2, 8, 10, 9};
		int[] result = solution(arr, 3);
		System.out.println(Arrays.toString(result));
	}
}
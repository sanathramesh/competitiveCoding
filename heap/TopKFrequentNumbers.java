import java.util.*;

class TopKFrequentNumbers {

	static class ArrayComparator implements Comparator<Integer[]> {
		@Override
		public int compare(Integer[] first, Integer[] second) {
			if(first[0]>second[0]) {
				return 1;
			} else if(first[0]==second[0]) {
				return 0;
			} else {
				return -1;
			}
		}
	}
	static int[] solution(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<arr.length; i++) {
			if(map.get(arr[i])!=null) {
				map.put(arr[i], map.get(arr[i])+1);
			} else {
				map.put(arr[i], 1);
			}
		}

		PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>(new ArrayComparator());
		for(Integer i : map.keySet()) {
			Integer[] temp = {map.get(i), i};
			maxHeap.add(temp);
			if(maxHeap.size()==k+1) {
				maxHeap.remove();
			}
		}
		int[] result = new int[k];
		int i = 0;
		while(maxHeap.size()>0) {
			result[i] = maxHeap.remove()[1];
			i++;
		}
		return result;
	} 

	public static void main(String[] args) {
		int[] arr = {1,2, 1, 3, 2, 1, 4};
		int k = 2;
		int[] result = solution(arr, k) ;

		System.out.println(Arrays.toString(result));
	}
}
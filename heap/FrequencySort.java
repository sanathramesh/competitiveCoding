import java.util.*;

class FrequencySort {
	static int[] solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer[]> heap = new PriorityQueue<>(new ArrayComparator());

		for(int i = 0; i<arr.length; i++) {
			if(map.get(arr[i])==null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}

		System.out.println(map.toString());

		for(Integer i : map.keySet()) {
			Integer[] temp = {map.get(i),i};
			heap.add(temp);
		}

		int[] result = new int[arr.length];
		int i=0;
		while(heap.size()>0) {
			Integer[] temp = heap.remove();
			Integer j = temp[0];
			Integer num = temp[1];
			while(j>0) {
				result[i] = num;
				j--;
				i++;
			}
		}

		return result;

	}

	static class ArrayComparator implements Comparator<Integer[]> {
		@Override
		public int compare(Integer[] first, Integer[] second) {
			if(first[0]>first[1]) {
				return -1;
			} else if(first[0]==first[1]) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2, 1, 3, 2, 1, 4};
		int[] result = solution(arr);
		System.out.println(Arrays.toString(result));
	}
}
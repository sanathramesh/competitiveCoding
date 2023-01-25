import java.util.*;

class prims {
	static void solution(List<Integer[]> edges, int n) {
		PriorityQueue<Integer[]> heap = new PriorityQueue<Integer[]>(new TempComparator());
		for(int i=0; i<edges.size(); i++) {
			heap.add(edges.get(i));
		}

		Set<Integer> visited = new HashSet<>();
		int i=0;

		List<Integer[]> result = new ArrayList<>();

		while(i<n && !heap.isEmpty()) {
			Integer[] current = heap.remove();
			if(visited.contains(current[0]) && visited.contains(current[1])) {
				continue;
			}
			result.add(current);
			visited.add(current[0]);
			visited.add(current[1]);
		}
		for(i=0; i<result.size(); i++) {
			System.out.println(Arrays.toString(result.get(i)));
		}

	}

	static class TempComparator implements Comparator<Integer[]> {
		@Override
		public int compare(Integer[] arr1, Integer[] arr2) {
			if(arr1[2]>arr2[2]) {
				return 1;
			} else if(arr1[2] == arr2[2]) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		List<Integer[]> edges = new ArrayList<>();
		edges.add(new Integer[]{0, 1, 2});
		edges.add(new Integer[]{0, 2, 3});
		edges.add(new Integer[]{1, 3, 2});
		edges.add(new Integer[]{2, 3, 1});
		solution(edges, 4);
	}
}
import java.util.*;

class MaxGCDInTree {
	static void solution(int[][] arr) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for(int i=0; i<arr.length; i++) {
			List<Integer> temp = map.getOrDefault(arr[i][0], new ArrayList<>());
			temp.add(arr[i][1]);
			map.put(arr[i][0], temp);
		}

		int maxGCD = 0;
		for(Integer key : map.keySet()) {
			List<Integer> temp = map.get(key);
			if(temp.size()==2) {
				int gcd = findGCD(temp.get(0), temp.get(1));
				if(gcd>maxGCD) {
					maxGCD = gcd;
				}
			}
		}
		System.out.println(maxGCD);
	}

	static int findGCD(int a, int b) {
		if(a==b) {
			return a;
		} else if(a>b){
			return findGCD(a-b, b);
		} else {
			return findGCD(a, b-a);
		}
	}

	public static void main(String[] args) {
		int[][] arr = {{5, 4}, {5, 8}, {4, 6}, {4, 9}, {8, 10}, {10, 20}, {10, 30}}  ;
		solution(arr);
	}
}
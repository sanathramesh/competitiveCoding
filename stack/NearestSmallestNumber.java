import java.util.*;

class NearestSmallestNumber {
	private static int[] solution(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int i=0;
		int[] result = new int[arr.length];
		while(i<arr.length) {
			if(s.isEmpty()) {
				s.push(arr[i]);
				result[i] = -1;
				i++;
			} else {
				if(s.peek()<arr[i]) {
					result[i] = s.peek();
					s.push(arr[i]);
					i++;
				} else {
					s.pop();
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 10, 8};
		int[] result = solution(arr);
		System.out.println(Arrays.toString(result));
	}
}
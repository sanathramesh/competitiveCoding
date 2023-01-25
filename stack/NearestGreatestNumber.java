import java.util.*;

class NearestGreatestNumber {

	private static int[] solution(int[] input) {
		int n = input.length;
		int[] result = new int[n];
		Stack<Integer> s = new Stack<Integer>();
		int i=n-1;
		while(i>=0) {
			if(s.isEmpty()) {
				result[i] = -1;
				s.push(input[i]);
				i--;
			} else {
				if(s.peek()>input[i]) {
					result[i] = s.peek();
					s.push(input[i]);
					i--;
				} else {
					s.pop();
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] input = {1, 3, 2, 4};
		int[] result = solution(input);
		System.out.println("hello there " + Arrays.toString(result));
	}
}
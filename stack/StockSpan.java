import java.util.*;

class StockSpan {
	private static int[] solution(int[] arr) {
		Stack<int[]> s = new Stack<>();
		int[] result = new int[arr.length];
		// Arrays.fill(result, 1);

		int i=0;
		while(i<arr.length) {
			if(s.isEmpty()) {
				int[] temp = {arr[i],i};
				result[i] = 1;
				s.push(temp);
				i++;
			} else {
				if(s.peek()[0]>arr[i]) {
					result[i] = result[i] +i-s.peek()[1];
					int[] temp = {arr[i], i };
					s.push(temp);
					i++;
				} else {
					s.pop();
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = {100, 80, 60, 70, 60, 75, 85};
		int[] result = solution(input);
		System.out.println(Arrays.toString(result));
	}
}
import java.util.*;

// identification is when the brute force approach is of the form i=0 to n and j depends on i
// tower of hanoi
// implement stack using heap
// celebrity problem
// iterative tower of hanoi
class MaximumAreaOfHistogram {
	private static int solution(int[] arr) {
		int result = Integer.MIN_VALUE;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		Arrays.fill(right, arr.length-1);

		Stack<Integer> s = new Stack<>();
		int i=0;
		while(i<arr.length ) {
			if(s.isEmpty()) {
				s.push(i);
				i++;
			} else {
				if(arr[s.peek()]<arr[i]) {
					left[i] = s.peek();
					s.push(i);
					i++;
				} else {
					s.pop();
				}
			}
		}

		s.clear();

		i=arr.length-1;
		while(i>=0) {
			if(s.isEmpty()) {
				s.push(i);
				i--;
			} else {
				if(arr[s.peek()]<arr[i]) {
					right[i] = s.peek();
					s.push(i);
					i--;
				} else {
					s.pop();
				}
			}
		}

		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		for(i=0;i<arr.length;i++) {
			int width = right[i] - left[i] - 1;
			result = Math.max(result, width*arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = {6, 2, 5, 4, 5, 1, 6};
		int result = solution(input);
		System.out.println(result);
	}
}
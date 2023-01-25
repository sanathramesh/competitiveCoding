import java.util.*;

class TempStack {
	Stack<Integer> s = new Stack<>();
	Stack<Integer> min = new Stack<>();

	void push(int num) {
		s.push(num);
		if(min.isEmpty()) {
			min.push(num);
		} else {
			if(num<=min.peek()) {
				min.push(num);
			}
		}
		System.out.println(s.toString());
		System.out.println(min.toString());
	}

	int pop() {
		if(s.isEmpty()){
			return Integer.MIN_VALUE;
		} else {
			int num = s.pop();
			if(num == min.peek()) {
				min.pop();
			}
			System.out.println(s.toString());
			System.out.println(min.toString());
			return num;
		}
	}

	int getMin() {
		if(min.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			return min.peek();
		}
	}

}

class StackWithExtraSpace {
	public static void main( String[] args) {
		TempStack stack = new TempStack();
		stack.push(18);
		stack.push(18);
		stack.push(19);
		stack.pop();
		stack.pop();
		stack.push(29);
		stack.push(16);
	}
}
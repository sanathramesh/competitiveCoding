import java.util.*;

class TempStack {
	int min;
	Stack<Integer> s = new Stack<Integer>();

	void push(int num) {
		if(s.isEmpty()) {
			s.push(num);
			min = num;
		} else {
			if(num<min) {
				s.push(2*num-min);
				min = num;
			} else {
				s.push(num);
			}
		}
	}

	int pop() {
		if(s.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			if(s.peek()>min) {
				return s.pop();
			} else {
				int num = min;
				min = 2*min-s.peek();
				s.pop();
				return num;
			}
		}
	}

	int getMin() {
		int num ;
		if(s.isEmpty()) {
			num =  Integer.MIN_VALUE;
		} else {
			num =  min;
		}
		System.out.println(num);
		return num;
	}
}

class StackWithoutExtraSpace {
	public static void main (String[] args) {
		TempStack stack = new TempStack();
		stack.push(18);
		stack.getMin();
		stack.push(18);
		stack.getMin();
		stack.push(19);
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.push(29);
		stack.getMin();
		stack.push(16);
		stack.getMin();
		stack.push(14);
		stack.getMin();
		stack.push(16);
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.getMin();
	}
}
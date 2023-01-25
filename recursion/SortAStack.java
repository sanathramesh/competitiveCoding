import java.util.*;

class SortAStack {
	static void solution (Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		} else {
			int num = s.pop();
			solution(s);
			Stack<Integer> temp = new Stack<Integer>();
			while(!s.isEmpty() && s.peek()>num) {
				temp.push(s.pop());
			}
			s.push(num);
			while(!temp.isEmpty()) {
				s.push(temp.pop());
			}
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(1);
		s.push(5);
		solution(s);
		System.out.println(s.toString());
	} 
}
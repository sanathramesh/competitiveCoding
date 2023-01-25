import java.util.*;

class ReverseAStack {
	static void solution(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		} else {
			Integer temp = s.pop();
			solution(s);
			insert(s, temp);
		}
	}

	static void insert(Stack<Integer> s, int num) {
		if(s.isEmpty()) {
			s.push(num);
			return;
		} else {
			int temp = s.pop();
			insert(s, num) ;
			s.push(temp);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		solution(s);
		System.out.println(s.toString());
	}
}
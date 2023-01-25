import java.util.*;

class DeleteMiddleElementOfStack {
	static void solution(Stack<Integer> s, int n) {
		if(n==s.size()-1) {
			s.pop();
			return;
		} else {
			Integer temp = s.pop();
			solution(s, n);
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
		solution(s, s.size()/2);
		System.out.println(s.toString());
	}
}
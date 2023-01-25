import java.util.*;

class Postfix {
	static int solution(String s) {
		Stack<Integer> stack = new Stack<>();
		char[] arr = s.toCharArray();
		for(int i=0; i<s.length(); i++) {
			if(arr[i]=='*' || arr[i]=='-' || arr[i]=='+' || arr[i]=='/')  {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				int result = 0;
				if(arr[i]=='*') {
					result = temp1 * temp2;
				} else if(arr[i]=='-') {
					result = temp2-temp1;
				} else if(arr[i]=='+') {
					result = temp1+temp2;
				} else {
					result = temp2/temp1;
				}
				stack.push(result);
			} else {
				stack.push(arr[i]-'0');
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String s = "231*+9-";
		System.out.println(solution(s));
	}
}
import java.util.*;

class KthSymbolInGrammar {
	static String solution(int n) {
		if(n==1) {
			return "0";
		} else {
			String temp = solution(n-1);
			return temp + complement(temp);
		}
	} 

	static String complement(String s) {
		String result = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='0') {
				result = result + '1';
			} else {
				result = result + '0';
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String result = solution(4);
		System.out.println(result);
	}
}
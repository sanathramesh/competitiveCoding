import java.util.*;

class PermutaitonWithCaseChange {
	static void solution(String s, List<String> result, int index, String currentString) {
		if(index == s.length()) {
			result.add(currentString);
		} else {
			solution(s, result, index + 1, currentString+s.charAt(index));
			solution(s, result, index + 1, currentString+Character.toUpperCase(s.charAt(index)));
		}
	}

	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		String s = "sanath";
		solution(s, result, 0, "");
		System.out.println(result);
	}
}
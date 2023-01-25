import java.util.*;

class PrintAllSubsets {
	static void solution(List<String> result, int index, String s, String currentString) {
		if(s.length()==index) {
			result.add(currentString);
			return;
		} else {
			solution(result, index+1, s, currentString+s.charAt(index));
			solution(result, index+1, s, currentString);
		}
	}

	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		solution(result, 0 , "sanath", "");

		System.out.println(result + " " + result.size());
	}
}
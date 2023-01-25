import java.util.*;

class PermutationWithSpaces {
	static void solution(List<String> result, String currentString, int index, String s, int numberOfSpaces) {
		if(index == s.length()) {
			if(numberOfSpaces==0) {
				result.add(currentString);
			}
			return;
		} else {
			if(index>0 && numberOfSpaces>0){
				solution(result, currentString + "_" + s.charAt(index), index+1, s, numberOfSpaces-1);
			}
			solution(result, currentString + s.charAt(index), index+1, s, numberOfSpaces);
		}
	}

	public static void main(String[] args) {
		String s = "sanathramesh";
		int numberOfSpaces = 2;
		List<String> result = new ArrayList<>();
		solution(result, "", 0, s, numberOfSpaces);
		System.out.println(result);
	}
}
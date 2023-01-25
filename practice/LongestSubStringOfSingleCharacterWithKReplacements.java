import java.util.*;

class LongestSubStringOfSingleCharacterWithKRelpacements {
	static void solution(String s, int k){
		int[] count = new int[26];
		int i=0, j=0;
		int maxLength = 0;
		while(j<s.length() && i<s.length()) {
			System.out.println(i + " " + j + " " + Arrays.toString(count) + " " + k + " " + findMax(count));
			if(j-i-findMax(count)<=k) {
				if(maxLength<j-i) {
					maxLength = j-i;
				}
				count[s.charAt(j)-'A'] = count[s.charAt(j)-'A'] + 1;
				j++;
			}
			else {
				count[s.charAt(i)-'A'] = count[s.charAt(i)-'A'] - 1;
				i++;
			}
		} 

		if(maxLength<j-i && j-i-findMax(count)<=k) {
			maxLength = j-i;
		}

		System.out.println(maxLength);
	}

	static int findMax(int[] count) {
		int max = -1;
		for(int i=0; i<26; i++) {
			if(max<count[i]){
				max = count[i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String s = "ABAA";
		int k = 0;
		solution(s, k);
	}
}
import java.util.*;

class LongestCommonSubString {
	static int solution (String s1, String s2, int index1, int index2, int[][] memory) {
		if(index1==s1.length() || index2==s2.length()) {
			return 0;
		}
		if(memory[index1][index2]!=-1) {
			return memory[index1][index2];
		}
		if(s1.charAt(index1)==s2.charAt(index2)) {
			memory[index1][index2] = 1 + solution(s1, s2, index1+1, index2+1, memory);
		} else {
			memory[index1][index2] = 0;
			solution(s1, s2, index1+1, index2, memory);
			solution(s1, s2, index1, index2+1, memory);
		}
		return memory[index1][index2];
	}

	public static void main(String[] args) { 
		String s1 = "sanath";
		String s2 = "stanappth";
		int[][] memory = new int[s1.length()][s2.length()];
		for(int i=0; i<memory.length; i++) { 
			Arrays.fill(memory[i], -1);
		}
		solution(s1, s2, 0, 0, memory);
		for(int i=0; i<memory.length; i++){
			System.out.println(Arrays.toString(memory[i]));
		}
	}
}
import java.util.*;

class LCSubString {
	static void solution(String s1, String s2) {
		int[][] memory = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		recur(s1, s2, 0, 0, memory);

		int i=0, j=0;
		String result = "";
		while(i<s1.length() && j<s2.length()) {
			if(s1.charAt(i)==s2.charAt(j)) {
				result = result + s1.charAt(i);
				i++;
				j++;
			} else {
				if(memory[i][j+1]>memory[i+1][j]) {
					j++;
				} else {
					i++;
				}
			}
		}
		System.out.println(result);
	}

	static int recur(String s1, String s2, int index1, int index2, int[][] memory) {
		if(index1>=s1.length() || index2>=s2.length()) {
			return 0;
		}
		if(memory[index1][index2]!=-1) {
			return memory[index1][index2];
		}
		int result=0;
		if(s1.charAt(index1)==s2.charAt(index2)) {
			result = 1 + recur(s1, s2, index1+1, index2+1, memory);
		} else {
			result = Math.max(recur(s1, s2, index1+1, index2, memory), recur(s1, s2, index1, index2+1, memory));
		}
		memory[index1][index2] = result;
		return result;
	}

	static void sol(String s1, String s2) {
		int[][] memory = new int[s1.length()+1][s2.length()+1];
		for(int i=1; i<s1.length()+1; i++) {
			for(int j=1; j<s2.length()+1; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					memory[i][j] = memory[i-1][j-1] + 1;
				} else {
					memory[i][j] = Math.max(memory[i-1][j], memory[i][j-1]);
				}
			}
		}

		int i=s1.length(), j=s2.length();
		String result = "";
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				result = s1.charAt(i-1) + result;
				i--;
				j--;
			} else {
				if(memory[i][j-1]>memory[i-1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		solution("sanath", "ramesh");
		sol("sanath", "ramesh");
	}
}
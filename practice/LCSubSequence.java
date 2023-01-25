import java.util.*;

class LCSubSequence {
	static void solution(String s1, String s2) {
		int[][] memory = new int[s1.length()+1][s2.length()];
		for(int i=0; i<s1.length()+1; i++) {
			Arrays.fill(memory[i], -1);
		}
		recur(s1, s2, 0, 0, memory);
		int max = -1;
		
		System.out.println("hello there1");
		for(int i=0; i<s1.length(); i++) {
			System.out.println(Arrays.toString(memory[i]));
			for(int j=0; j<s2.length(); j++) {
				max = Math.max(max, memory[i][j]);
			}
		}
		if(max==0) {
			return;
		}

		System.out.println("hello there");

		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				if(memory[i][j]==max) {
					System.out.println(s1.substring(i, i+max));
					return;
				}
			}
		}
	}

	static int recur(String s1, String s2, int index1, int index2, int[][] memory) {
		if(index1>=s1.length() || index2>=s2.length()) {
			return 0;
		}
		if(memory[index1][index2]!=-1) {
			return memory[index1][index2];
		}
		if(s1.charAt(index1)==s2.charAt(index2)) {
			memory[index1][index2] = 1 + recur(s1, s2, index1+1, index2+1, memory);
		} else {
			memory[index1][index2] = 0;
			recur(s1, s2, index1+1, index2, memory);
			recur(s1, s2, index1, index2+1, memory);
		}
		return memory[index1][index2];
	}

	static void sol(String s1, String s2) {
		int[][] memory = new int[s1.length()+1][s2.length()+1];

		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					memory[i][j] = memory[i-1][j-1] + 1;
				} else {
					memory[i][j] = 0;
				}
			}
		}
		int max = -1;
		int index = -1;
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(max<memory[i][j]) {
					index = i;
					max = memory[i][j];
				}
			}
		}
		if(max<=0) {
			return ;
		}

		System.out.println(s1.substring(index-max,index));

	}

	public static void main(String[] args) {
		solution("sand", "candy");
		sol("sand", "candy");
	}
}
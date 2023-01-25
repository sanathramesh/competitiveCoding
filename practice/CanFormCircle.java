import java.util.*;

class CanFormCircle {
	static void solution(String[] strings) {
		char[] start = new char[strings.length];
		char[] end = new char[strings.length];

		for(int i=0; i<strings.length; i++) {
			start[i] = strings[i].charAt(0);
			end[i] = strings[i].charAt(strings[i].length()-1);
		}
		int[] visited = new int[strings.length];
		System.out.println(recur(0, 0, strings.length-1, visited, start, end));
	}

	static boolean recur(int parent, int current, int count, int[] visited, char[] start, char[] end) {
		if(count==0) {
			if(start[parent] == end[current]) {
				return true;
			} else {
				return false;
			}
		}
		visited[current] = 1;

		boolean result = false;
		System.out.println(parent + " " + current + " " + Arrays.toString(visited));
		for(int i=0; i<start.length; i++) {
			if(visited[i]!=1 && end[current]==start[i]) {
				result = result || recur(parent, i, count-1, visited, start, end);
			}
		}
		return result;

	}



	public static void main(String[] args){
		String[] s = {"ijk", "kji", "abc", "cba"};
		solution(s);
	}
}
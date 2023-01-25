import java.util.*;

class MSB {
	static void solution(int n) {
		String[] arr = "san:ath".split(":");
		String s = "sanath";
		s = s.replace("a", "b");

		System.out.println(Arrays.toString(arr) + " " + s);

	}

	public static void main(String[] args) {
		solution(3);
	}
}
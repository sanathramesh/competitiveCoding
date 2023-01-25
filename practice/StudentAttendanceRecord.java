import java.util.*;

class StudentAttendanceRecord {
	static int solution(int n, int l, int a, Integer[][][] memory) {
		if(n==0) {
			return 1;
		}

		int sum = 0;

		if(memory[n][l][a]!=null) {
			return memory[n][l][a];
		}

		if(l<2) {
			if(a<1) {
				sum = (sum%1000000007 + solution(n-1, 0, a+1, memory)%1000000007)%1000000007;
			} 
			sum = (sum%1000000007+ solution(n-1, l+1, a, memory)%1000000007)%1000000007;
		} else {
			if(a<1) {
				sum = (sum%1000000007 + solution(n-1, 0, a+1, memory)%1000000007)%1000000007;
			}
		}

		sum = (sum%1000000007 + solution(n-1, 0, a, memory)%1000000007)%1000000007;
		memory[n][l][a] = sum;

		return sum;
	}

	public static void main(String[] args) {
		int n = 2;
		Integer[][][] memory = new Integer[n+1][3][2];
		System.out.println(solution(n, 0, 0, memory));
	}
}
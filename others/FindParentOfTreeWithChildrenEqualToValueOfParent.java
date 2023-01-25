import java.util.*;

class FindParentOfTreeWithChildrenEqualToValueOfParent {

	static int solution(int n) {
		if(n==1) {
			return -1;
		}
		int result = -1;
		int prevStart = 1, prevEnd = 1;

		while(n>prevEnd) {
			int currentStart = prevEnd+1;
			int currentEnd = prevEnd + (prevEnd*(prevEnd+1))/2 - (prevStart*(prevStart-1))/2;
			if(n>=currentStart && n<=currentEnd) {
				break;
			} else {
				prevStart = currentStart;
				prevEnd = currentEnd;
			}
		}

		n = n-prevEnd;
		int sum = 0;
		for(int i = prevStart; i<=prevEnd; i++) {
			if(n>sum && n<=sum+i) {
				return i;
			} else {
				sum = i + sum;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(7));
	}

}
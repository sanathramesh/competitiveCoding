import java.util.*;

class Pair {
	Integer first;
	Integer second;

	public Pair(Integer first, Integer second) {
		this.first = first;
		this.second = second;
	}
}

class FindMissingAndDuplicateNumber {
	static Pair solution (int[] arr) {
		int sumOfN = (arr.length*(arr.length+1))/2;
		int sumOfNsquare = (arr.length*(arr.length+1)*(2*arr.length+1))/6;
		int sum = 0;
		int sumSquare = 0;

		for(int n : arr) {
			sum = sum + n;
			sumSquare = sumSquare + n*n;
		}

		int diff = sumOfN-sum;
		int diffSquare = sumOfNsquare - sumSquare;
		int sumOfNum = diffSquare/diff;

		int missingNum = (diff+sumOfNum)/2;

		int duplicate = sumOfNum - missingNum;
		return new Pair(missingNum, duplicate);
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 2, 5};

		Pair nums = solution(arr);

		System.out.println(nums.first + " " + nums.second);
	}
}
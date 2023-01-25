import java.util.*;

class NBitNumbersWithMore1s {
	static void solution(List<String> result, int numberOfOnes, int n) {
		recur(result, "", numberOfOnes, n-numberOfOnes, n);
	}

	static void recur(List<String> result, String currentString, int numberOfOnes, int numberOfZeros, int n) {
		if(currentString.length()==n) {
			result.add(currentString);
		} else {
			if(numberOfOnes>0) {
				recur(result, currentString +"1", numberOfOnes-1, numberOfZeros, n);
			} 
			if(numberOfZeros>0) {
				recur(result, currentString +"0", numberOfOnes, numberOfZeros-1, n);
			}
		}
	}

	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		int n = 6;
		int numberOfones = n/2 + 1;
		while(numberOfones <=n) {
			solution(result, numberOfones, n);
			numberOfones++;
		}

		System.out.println(result);
	}
}
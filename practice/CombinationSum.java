import java.util.*;

class CombinationSum {
	static void solution(int[] arr, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		recur(arr, -1, 0, n , n, temp, result);
		System.out.println(result);
	}

	static void recur(int[] arr, int lastIndex, int currentIndex, int n, int sum, 
		List<Integer> result, List<List<Integer>> total) {
		if(sum==0) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(result);
			total.add(temp);
			return;
		}
		if(currentIndex >= arr.length) {
			return;
		}

		if(lastIndex!=-1) {
			if(arr[currentIndex]>=arr[lastIndex] && arr[currentIndex]<=sum) {
				result.add(arr[currentIndex]);
				recur(arr, currentIndex, currentIndex, n, sum-arr[currentIndex], result, total);
				result.remove(result.size()-1);
				recur(arr, lastIndex, currentIndex+1, n, sum, result, total);
			} else {
				recur(arr, lastIndex, currentIndex+1, n, sum, result, total);
			}
		} else {
			if(arr[currentIndex]<=sum) {
				result.add(arr[currentIndex]);
				recur(arr, currentIndex, currentIndex, n, sum-arr[currentIndex], result, total);
				result.remove(result.size()-1);
				recur(arr, lastIndex, currentIndex+1, n, sum , result, total);
			} else {
				recur(arr, lastIndex, currentIndex+1, n , sum, result, total);
			}
		}
		return;
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 6, 7};
		int n = 7;
		solution(arr, n);
	}
}
import java.util.*;

class FirstAndLastOccurence {
	static int[] solution(int[] arr, int n) {
		int start = 0 , end = arr.length-1;

		int[] result = {-1, -1};


		//finding the first occurence;
		while (start<=end) {
			int mid = (start + end )/2;
			if(arr[mid] == n) {
				if(mid==0) {
					result[0] = 0;
					break;
				} else {
					if(arr[mid-1]!=n) {
						result[0] = mid;
						break;
					} else {
						end = mid-1;
					}
				}
			} else if(arr[mid] < n) {
				start = mid + 1;
			} else {
				end  = mid - 1;
			}
		}


		start = 0 ; end = arr.length-1;
		//finding the last occurence 
		while (start<=end) {
			int mid = (start + end )/2;
			if(arr[mid] == n) {
				if(mid==arr.length-1) {
					result[1] = arr.length-1;
					break;
				} else {
					if(arr[mid+1]!=n) {
						result[1] = mid ;
						break;
					} else {
						start = mid + 1;
					}
				}
			} else if(arr[mid] < n) {
				start = mid + 1;
			} else {
				end  = mid - 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 4, 4, 5};
		int n = 4;
		int[] result = solution(input, n);
		System.out.println(Arrays.toString(result));
	}
}
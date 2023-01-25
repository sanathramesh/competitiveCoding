class EggDropping {
	static void solution(int egg, int floors) {

	}

	static void recur(int egg, int floor) {
		if(egg==1) {
			return floor;
		} 
		if(floor==0 || floor==1) {
			return floor;
		}

		int max = Integer.MIN_VALUE;
		int res = Integer.MAX_VALUE;
		for(int k=i; k<=j; k++) {
			max = 1+Math.max(recur(egg-1, k-1), recur(egg, j-k));
			res = Math.min(res, max);
		}

		return res;
	}

	public static void main(String[] args ) {
		solution(3, 5);
	}
}
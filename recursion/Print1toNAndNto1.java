class Print1toNAndNto1 {
	static void solution(int n) {
		forward(n);
		backward(n);
	}

	static void forward(int n) {
		if(n==0) {
			return ;
		} else {
			forward(n-1);
			System.out.print(n);
		}
	}

	static void backward(int n) {
		if(n==0) {
			return;
		} else {
			System.out.print(n);
			backward(n-1);
		}
	}

	public static void main(String[] args) {
		int n = 7;
		solution(n);
	}
}
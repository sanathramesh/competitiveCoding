import java.util.Arrays;

// Java program to memoize
// recursive implementation of LCS problem
class GFG {

	static final int maximum = 1000;

// Returns length of LCS for X[0..m-1], Y[0..n-1] */
// memoization applied in recursive solution
	static int lcs(String X, String Y, int m, int n, int[][] dp) {
		// base case
		if (m == 0 || n == 0) {
			return 0;
		}

		// if the same state has already been
		// computed
		if (dp[m - 1][n - 1] != -1) {
			return dp[m - 1][n - 1];
		}

		// if equal, then we store the value of the
		// function call
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {

			// store it in arr to avoid further repetitive
			// work in future function calls
			dp[m - 1][n - 1] = 1 + lcs(X, Y, m - 1, n - 1, dp);

			return dp[m - 1][n - 1];
		} else {

			// store it in arr to avoid further repetitive
			// work in future function calls
			dp[m - 1][n - 1] = Math.max(lcs(X, Y, m, n - 1, dp),
					lcs(X, Y, m - 1, n, dp));

			return dp[m - 1][n - 1];
		}
	}

// Driver Code
	public static void main(String[] args) {
		String X = "sanath";
		String Y = "ramesh";
		int m = X.length();
		int n = Y.length();

		int dp[][] = new int[m][maximum];

		// assign -1 to all positions
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
      
      

		System.out.println("Length of LCS: " 
                           + lcs(X, Y, m, n, dp));
		for(int i=0; i<dp.length; i++) {
        System.out.println(Arrays.toString(dp[i]));
      }
   }
}
/* This Java code is contributed by 29AjayKumar*/

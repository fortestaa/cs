package Chapter8_DynamicProgramming;

/**
 * 43. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * 
 * Question:
 * A robot is located at the top-left corner of a m × n grid (marked ‘Start’ in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 * How many possible unique paths are there?
 */
public class Unique_Paths {

	/**
	 * O( C(m+n,m) ) runtime, O(m+n) space – Backtracking:
	 * The most direct way is to write code that traverses each possible path, which can be done using backtracking.
	 * When you reach row = m and col = n, you know you’ve reached the bottom-right corner, and there is one additional unique path to it.
	 * However, when you reach row > m or col > n, then it’s an invalid path and you should stop traversing.
	 * For any grid at row = r and col = c, you have two choices: Traverse to the right or traverse to the bottom.
	 * Therefore, the total unique paths at grid (r, c) are equal to the sum of total unique paths from the grid to the right and the grid below.
	 * Deriving the runtime complexity is slightly tricky. Observe that the robot must go right exactly m times and go down exactly n times.
	 * Assume that the right movement is 0 and the down movement is 1.
	 * We could then represent the robot’s path as a binary string of length = m + n, where the string contains m zeros and n ones.
	 * Since the backtracking algorithm is just trying to explore all possibilities, its runtime complexity is equivalent to the total permutations of a binary string that contains m zeros and n ones, which is C(m+n,m).
	 * On the other hand, the space complexity is due to the recursion that goes at most m + n level deep
	 */
	private int backtrack(int r, int c, int m, int n) {
		if (r == m - 1 && c == n - 1)
			return 1;
		if (r >= m && c >= n)
			return 0;
		return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
	}	
	public int uniquePaths(int m, int n) {
		return backtrack(0, 0, m, n);
	}
	
	/**
	 * Improved Backtracking Solution using Memoization:
	 * Although the above backtracking solution is easy to code, it is very inefficient in the sense that it recalculates the same solution for a grid over and over again.
	 * By caching the results, we prevent recalculation and only calculate when necessary. Here, we are using a dynamic programming (DP) technique called memoization.
	 */
	private int backtrack2(int r, int c, int m, int n, int[][] mat) {
		if (r == m - 1 && c == n - 1)
			return 1;
		if (r >= m || c >= n)
			return 0;
		
		if (mat[r + 1][c] == -1)
			mat[r + 1][c] = backtrack2(r + 1, c, m, n, mat);
		if (mat[r][c + 1] == -1)
			mat[r][c + 1] = backtrack2(r, c + 1, m, n, mat);
		return mat[r + 1][c] + mat[r][c + 1];
	}
	public int uniquePaths2(int m, int n) {
		int[][] mat = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				mat[i][j] = -1;
			}
		}
		return backtrack2(0, 0, m, n, mat);
	}
	
	/**
	 * O(mn) runtime, O(mn) space – Bottom-up dynamic programming:
	 * If you notice closely, the above DP solution is using a top-down approach. Now let’s try a bottom-up approach. Remember this important relationship that is necessary for this DP solution to work:
	 * The total unique paths at grid (r, c) are equal to the sum of total unique paths from grid to the right (r, c + 1) and the grid below (r + 1, c).
	 * How can this relationship help us solve the problem? We observe that all grids of the bottom edge and right edge must all have only one unique path to the bottom-right corner.
	 * Using this as the base case, we can build our way up to our solution at grid (1, 1) using the relationship above.
	 */
	public int uniquePaths3(int m, int n) {
		int[][] mat = new int[m + 1][n + 1];
		mat[m - 1][n] = 1;
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
			}
		}
		return mat[0][0];
	}
	/*
	 * Combinatorial Solution:
	 * It turns out this problem could be solved using combinatorics, which no doubt would be the most efficient solution.
	 * In order to see it as a combinatorial problem, there are some necessary observations.
	 * Look at the 7×3 sample grid in the picture above. Notice that no matter how you traverse the grids, you always traverse a total of 8 steps.
	 * To be more exact, you always have to choose 6 steps to the right (R) and 2 steps to the bottom (B).
	 * Therefore, the problem can be transformed to a question of how many ways can you choose 6R‘s and 2B‘s in these 8 steps.
	 * The answer is or C(8,2) or C(8,6). Therefore, the general solution for an m ×n grid is C(m+n-2, m-1).
	 * 
	 * Further Thoughts:
	 * Now consider if some obstacles are added to the grids marked as ‘X’. How many unique paths would there be?
	 * A combinatorial solution is difficult to obtain, but the DP solution can be modified easily to accommodate this constraint.
	 * See Question [44. Unique Paths II].
	 */
}
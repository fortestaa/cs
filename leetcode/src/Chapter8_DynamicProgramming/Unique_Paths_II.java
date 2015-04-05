package Chapter8_DynamicProgramming;

/**
 * 44. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * Question:
 * Similar to Question [43. Unique Paths], but now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space are marked as 1 and 0 respectively in the grid. For example,
 * There is one obstacle in the middle of a 3×3 grid as illustrated below.
 * [
 * 	[0,0,0]
 * 	[0,1,0]
 * 	[0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class Unique_Paths_II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)	return 0;
		int n = obstacleGrid[0].length;
		int[][] mat = new int[m + 1][n + 1];
		mat[m - 1][n] = 1;
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				mat[r][c] = (obstacleGrid[r][c] == 1) ? 0 : mat[r][c + 1] + mat[r + 1][c];
			}
		}
		return mat[0][0];
	}
}
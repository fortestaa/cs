package Chapter6_Misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 35. Spiral Matrix
 * 
 * Question:
 * Given a matrix of m ✕ n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example, given the following matrix:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Spiral_Matrix {

	/**
	 * Solution:
	 * 
	 * Figure 3: A m ✕ n matrix.[p67] The arrows show the direction of traversal in spiral order.
	 * We simulate walking the matrix from the top left corner in a spiral manner.
	 * In the outmost level, we traverse n steps right, m – 1 steps down, n – 1 steps left, and m – 2 steps up, then we continue traverse into its next inner level.
	 * As the traversal spiral toward the matrix’s center, we stop by determining if we have reached the “center”.
	 * However, defining the “center” is difficult since the matrix is not necessarily a square.
	 * Think of edge cases such as 1✕1, 1✕10 and 10✕1 matrices, where is the “center”?
	 * These cases had to be dealt separately and are messy.
	 * A cleaner solution is to keep track of our current position and the number of steps in both horizontal and vertical directions.
	 * As we change direction we decrement the steps in that direction.
	 * When the number of steps in a direction becomes zero, we know that we have finished traversing the entire matrix.
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> elements = new ArrayList<>();
		if (matrix.length == 0)	return elements;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = -1;
		while (true) {
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][++col]);
			}
			if (--m == 0)	break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[++row][col]);
			}
			if (--n == 0)	break;
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][--col]);
			}
			if (--m == 0)	break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[--row][col]);
			}
			if (--n == 0)	break;
		}
		return elements;
	}
}
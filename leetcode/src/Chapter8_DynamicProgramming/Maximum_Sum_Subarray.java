package Chapter8_DynamicProgramming;

/**
 * 45. Maximum Sum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Question:
 * Find the contiguous subarray within an array (containing at least one number) that has the largest sum.
 * For example, given the array [2, 1, –3, 4, –1, 2, 1, –5, 4], The contiguous array [4, –1, 2, 1] has the largest sum = 6.
 */
public class Maximum_Sum_Subarray {

	/**
	 * O(n log n) runtime, O(log n) stack space – Divide and Conquer:
	 * Assume we partition the array A into two smaller arrays S and T at the middle index, M.
	 * Then, S = A1 ... AM-1, and T = AM+1 ... AN.
	 * The contiguous subarray that has the largest sum could either:
	 * i. Contain the middle element:
	 * 	a. The largest sum is the maximum suffix sum of S + AM + the maximum prefix sum of T.
	 * ii. Does not contain the middle element:
	 * 	a. The largest sum is in S, which we could apply the same algorithm to S.
	 * 	b. The largest sum is in T, which we could apply the same algorithm to T.
	 */
	public int maxSubArray(int[] A) {
		return maxSubArrayHelper(A, 0, A.length - 1);
	}
	private int maxSubArrayHelper(int[] A, int L, int R) {
		if (L > R)	return Integer.MIN_VALUE;
		int M = (L + R) / 2;
		int leftAns = maxSubArrayHelper(A, L, M - 1);
		int rightAns = maxSubArrayHelper(A, M + 1, R);
		int lMaxSum = 0;
		int sum = 0;
		for (int i = M - 1; i >= L; i--) {
			sum += A[i];
			lMaxSum = Math.max(sum, lMaxSum);
		}
		int rMaxSum = 0;
		sum = 0;
		for (int i = M + 1; i <= R; i++) {
			sum += A[i];
			rMaxSum = Math.max(sum, rMaxSum);
		}
		return Math.max(lMaxSum + A[M] + rMaxSum, Math.max(leftAns, rightAns));
	}
	/*
	 * The runtime complexity could be expressed as T(n)=2T(n/2)+O(n), which is O(n log n).
	 * We will not attempt to prove it here; you could read up any advanced algorithm textbooks to learn the proof.
	 */
	
	/**
	 * O(n) runtime, O(1) space – Dynamic programming:
	 * To devise a dynamic programming formula, let us assume that we are calculating the maximum sum of subarray that ends at a specific index. Let us denote that:
	 * f(k) = Maximum sum of subarray ending at index k. Then,
	 * f(k) = max( f(k-1) + A[k], A[k] )
	 * Using an array of size n, We could deduce the final answer by as f(n – 1), with the initial state of f(0) = A[0].
	 * Since we only need to access its previous element at each step, two variables are sufficient.
	 * Notice the difference between the two: maxEndingHere and maxSoFar;
	 * the former is the maximum sum of subarray that must end at index k,
	 * while the latter is the global maximum subarray sum.
	 */
	public int maxSubArray2(int[] A) {
		int maxEndingHere = A[0], maxSoFar = A[0];
		for (int i = 0; i < A.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
}
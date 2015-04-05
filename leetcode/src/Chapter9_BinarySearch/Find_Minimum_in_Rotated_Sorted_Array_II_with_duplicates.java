package Chapter9_BinarySearch;

/**
 * 50. Find Minimum in Rotated Sorted Array II – with duplicates
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 
 * Question:
 * If the rotated sorted array could contain duplicates? Is your algorithm still O(log n) in runtime complexity?
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II_with_duplicates {

	/**
	 * For case where AL == AM == AR, the minimum could be on AM’s left or right side (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]).
	 * In this case, we could not discard either subarrays and therefore such worst case degenerates to the order of O(n).
	 */
	public int findMin(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else if (A[M] < A[L]) {
				R = M;
			} else {	// A[L] == A[M] == A[R]
				L = L + 1;
			}
		}
		return A[L];
	}
}
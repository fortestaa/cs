package easy;

public class Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (count == 0 || A[i] != A[count - 1]) {
				A[count++] = A[i];
			}
		}
		return count;
	}
}

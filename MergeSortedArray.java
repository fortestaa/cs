package easy;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	// mine
	public void merge0(int A[], int m, int B[], int n) {
		int i = 0, j = 0;
        int[] res = new int[m + n];
        int count = 0;
        while (i < m || j < n) {
            int a = i < m ? A[i] : Integer.MAX_VALUE;
            int b = j < n ? B[j] : Integer.MAX_VALUE;
            if (a < b) {
                res[count++] = a;
                i++;
            } else {
                res[count++] = b;
                j++;
            }
        }
        for (int k = 0; k < m + n; k++) {
            A[k] = res[k];
        }
	}
	
	// merge from behind
	public void merge(int A[], int m, int B[], int n) {
		if (n == 0)	return;
		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m--;
			} else {
				A[m + n - 1] = B[n - 1];
				n--;
			}
		}
		/* still elements in B */
		while (n > 0)	A[n - 1] = B[n-- - 1];
	}
	
	/*public static void main(String[] args) {
		MergeSortedArray m = new MergeSortedArray();
		int[] A = new int[100];
		A[0] = 1;
		//int A[] = {1};
		int B[] = {2};
		m.merge(A, 1, B, 1);
		for (int i = 0; i < A.length; i++)
				System.out.println(A[i]);
	}*/
}

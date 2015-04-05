package Chapter5_BitManipulation;

/**
 * Question:
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * p65
 */
public class Single_Number_II {

	/**
	 * To solve this problem using only constant space, you have to rethink how the numbers are being represented in computers – using bits.
	 * If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 due to the constraint of this problem where each number must appear either three times or once.
	 * This will be the ith bit of that "single number".
	 * A straightforward implementation is to use an array of size 32 to keep track of the total count of ith bit.
	 */
	/*int singleNumber(int A[], int n) {
		int count[32] = {0};
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < n; j++) {
				if ((A[j] >> i) & 1) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		return result;
	}*/
	
	int singleNumber(int A[], int n) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < n; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
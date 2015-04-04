package easy;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	// mine
	public int[] plusOne0(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
        	int digit = digits[i];
        	if (digit < 9) {
        		digits[i] += 1;
        		return digits;
        	} else {
        		if (i != 0) {
        			digits[i] = 0;
        		} else {
        			int[] result = new int[len + 1];
        			result[0] = 1;
        			return result;
        		}
        	}
        }
        return digits;
    }
	
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		
		int [] result = new int[digits.length + 1];
		result[0] = 1;
		for (int i = 0; i < digits.length; i++) {
			result[i + 1] = digits[i];
		}
		return result;
	}
}

package easy;

/**
 * Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class Factorial_Trailing_Zeroes_ {
    public int trailingZeroes(int n) {
    	int r = 0;
    	while (n > 0) {
    		n /= 5;
    		r += n;
    	}
    	return r;
    }
    
    public static void main(String[] args) {
    	Factorial_Trailing_Zeroes_ f = new Factorial_Trailing_Zeroes_();
    	System.out.println(f.trailingZeroes(0));
    	System.out.println(f.trailingZeroes(2));
    	System.out.println(f.trailingZeroes(5));
    	System.out.println(f.trailingZeroes(25));
    }
}

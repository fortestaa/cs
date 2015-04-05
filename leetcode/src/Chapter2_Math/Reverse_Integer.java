package Chapter2_Math;

/**
 * 17. Reverse Integer
 * Code it now: https://oj.leetcode.com/problems/reverse-integer/
 * 
 * Question:
 * Reverse digits of an integer. For example: x = 123, return 321. 
 * 
 * Example Questions Candidate Might Ask:
 * Q: What about negative integers?
 * A: For input x = –123, you should return –321.
 * Q: What if the integer’s last digit is 0? For example, x = 10, 100, ...
 * A: Ignore the leading 0 digits of the reversed integer. 10 and 100 are both reversed as 1.
 * Q: What if the reversed integer overflows? For example, input x = 1000000003.
 * A: In this case, your function should return 0.
 */
public class Reverse_Integer {

	/* code with flaw */
	public int reverse0(int x) {
		int ret = 0;
		while (x != 0) {
			ret = ret * 10 + x % 10;
			x /= 10;
		}
		return ret;
	}
	/*
	 * There is a flaw in the above code – the reversed integer could overflow/underflow.
	 * Take x = 1000000003 for example. To check for overflow/underflow, we could check if ret > 214748364 or ret < –214748364 before multiplying by 10.
	 * On the other hand, if ret == 214748364, it must not overflow because the last reversed digit is guaranteed to be 1 due to constraint of the input x.
	 */
	
	public int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			// handle overflow/underflow
			if (Math.abs(ret) > 214748364) {
				return 0;
			}
			ret = ret * 10 + x % 10;
			x /= 10;
		}
		return ret;
	}
}

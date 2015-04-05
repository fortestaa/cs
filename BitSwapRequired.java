package chapter5;

/**
 * 5.5
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * */
public class BitSwapRequired {
	
	/*
	 * This seemingly complex problem is actually rather straightforward. 
	 * To approach this, ask yourself how you would figure out which bits in two numbers are different. 
	 * Simple: with an XOR.
	 * Each 1 in the XOR represents a bit that is different between A and B. 
	 * Therefore, to check the number of bits that are different between A and B, 
	 * we simply need to count the number of bits in A^B that are 1.
	 * */
	int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	/*
	 * This code is good, but we can make it a bit better. 
	 * Rather than simply shifting c repeatedly while checking the least significant bit, 
	 * we can continuously flip the least significant bit and count how long it takes c to reach 0. 
	 * The operation c = c & (c - l) will clear the least significant bit in c.
	 */
	public static int bitSwapRequired2(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}
	/*
	 * The above code is one of those bit manipulation problems that comes up sometimes in interviews.
	 * Though it'd be hard to come up with it on the spot if you've never seen it before, 
	 * it is useful to remember the trick for your interviews.
	 */
}

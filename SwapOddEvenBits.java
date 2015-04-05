package chapter5;

/**
 * 5.6
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g.,bit 0 and bit 1 are swapped,bit 2 and bit 3 are swapped,and so on).
 * */
public class SwapOddEvenBits {
	
	/*
	 * Like many of the previous problems, it's useful to think about this problem in a different way. 
	 * Operating on individual pairs of bits would be difficult, and probably not that efficient either.
	 * So how else can we think about this problem?
	 * We can approach this as operating on the odds bits first, and then the even bits.
	 * Can we take a number n and move the odd bits over by 1 ?
	 * Sure. We can mask all odd bits with 10101010 in binary (which is 0xAA), 
	 * then shift them right by 1 to put them in the even spots. 
	 * For the even bits, we do an equivalent operation. Finally, we merge these two values.
	 * This takes a total of five instructions. The code below implements this approach.
	 * */
	public int swapOddEvenBits(int x) {
		return ( ((x & 0xaaaaaaaa) >> 1) | (x & 0x55555555) << 1);
	}
	/*
	 * We've implemented the code above for 32-bit integers in Java.
	 * If you were working with 64-bit integers, you would need to change the mask.
	 * The logic, however, would remain the same.
	 */
}

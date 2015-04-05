package chapter5;

/**
 * 5.3
 * Given a positive integer, print the next smallest and the next largest number 
 * that have the same number of 1 bits in their binary representation.
 */
public class PrintNext {
	
	/*
	 * The Brute Force Approach
	 * count the number of 1 s in n, and then increment (or decrement) until you find a number with the same number of 1s.
	 * Easy—but not terribly interesting. Can we do something a bit more optimal?
	 * Yes! Let's start with the code for getNext, and then move on to getPrev.
	 * */
	
	/*
	 * Bit Manipulation Approach for Get Next Number
	 * If we think about what the next number should be,we can observe the following. Given the number 13948, the binary representation looks like:
	 * 1	1	0	1	1	0	0	1	1	1	1	1	0	0
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * We want to make this number bigger (but not too big). We also need to keep the same number of ones.
	 * Observation: Given a number n and two bit locations i and j, suppose we flip bit i from a 1 to a 0, and bit j from a 0 to a 1. If i > j, then n will have decreased. If i < j, then n will have increased.
	 * We know the following:
	 * 1. If we flip a zero to a one, we must flip a one to a zero.
	 * 2. When we do that, the number will be bigger if and only if the zero-to-one bit was to the left of the one-to-zero bit.
	 * 3. We want to make the number bigger, but not unnecessarily bigger. Therefore, we need to flip the rightmost zero which has ones on the right of it.
	 * To put this in a different way, we are flipping the rightmost non-trailing zero. That is, using the above example, the trailing zeros are in the Oth and 1 st spot. The rightmost non-trailing zero is at bit 7. Let's call this position p.
	 * 
	 * Step 1: Flip rightmost non-trailing zero
	 * 1	1	0	1	1	0	1	1	1	1	1	1	0	0
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * With this change, we have increased the size of n. But, we also have one too many ones, and one too few zeros. We'll need to shrink the size of our number as much as possible while keeping that in mind.
	 * We can shrink the number by rearranging all the bits to the right of bit p such that the Os are on the left and the 1s are on the right. As we do this, we want to replace one of the 1s with a 0.
	 * A relatively easy way of doing this is to count how many ones are to the right of p, clear all the bits from 0 until p, and then add back in cl-1 ones.Let cl be the number of ones to the right of p and c0 be the number of zeros to the right of p.
	 * 
	 * Step 2: Clear bits to the right of p. From before, c0 = 2. cl = 5. p = 7.
	 * 1	1	0	1	1	0	1	0	0	0	0	0	0	0
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * To clear these bits, we need to create a mask that is a sequence of ones, followed by p zeros. We can do this as follows:
	 * 	a = 1 « p;	// all zeros except for a 1 at position p.
	 * 	b = a - 1; 	// all zeros, followed by p ones,
	 * 	mask = ~b; 	// all ones, followed by p zeros,
	 * 	n = n & mask; // clears rightmost p bits.
	 * Or, more concisely, we do n &= ~((1 « p) - 1).
	 * 1	1	0	1	1	0	1	0	0	0	0	0	0	0
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0 
	 * 
	 * Step 3: Add in c1 - l ones.
	 *  1	1	0	1	1	0	1	0	0	0	1	1	1	1
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * To insert c1 - 1 ones on the right, we do the following:
	 * 	a = 1 « (c1-1);	// 0s with a 1 at position c1-1 
	 * 	b = a - 1; 		// 0s with 1s at positions 0 through c1-1 
	 * 	n = n | b; 		// inserts 1s at positions 0 through c1-1
	 * Or, more concisely: n |= (1 « (c1 - 1)) - l;
	 * We have now arrived at the smallest number bigger than n with the same number of ones.
	 * */
	public int getNext(int n) {
		/* Compute c0 and c1 */
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		/* Error: if n == 11..1100...00, then there is no bigger number with the same number of 1s. */
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		int p = c0 + c1;	// position of rightmost non-trailing zero
		
		n |= (1 << p);	// Flip rightmost non-trailing zero
		n &= ~((1 << p) - 1);	// Clear all bits to the right of p
		n |= (1 << (c1 - 1)) - 1;	// Insert (c1 - 1) ones on the right.
		return n;
	}

	/*
	 * Bit Manipulation Approach for Get Previous Number
	 * To implement getPrev,we follow a very similar approach.
	 * 1. Compute c0 and c1. Note that c1 is the number of trailing ones, and c0 is the size of the block of zeros immediately to the left of the trailing ones.
	 * 2. Flip the rightmost non-trailing one to a zero. This will be at position p = c1 + c0.
	 * 3. Clear all bits to the right of bit p.
	 * 4. Insert c1 + 1 ones immediately to the right of position p.
	 * Note that Step 2 sets bit p to a zero and Step 3 sets bits 0 through p-1 to a zero. We can merge these steps.
	 * 
	 * Step 1: Initial Number, p = 7. c1 = 2. c0 = 5.
	 * 1	0	0	1	1	1	1	0	0	0	0	0	1	1
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * 
	 * Steps 2 & 3: Clear bits 0 through p.
	 * 1	0	0	1	1	1	0	0	0	0	0	0	0	0
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * We can do this as follows:
	 * 	int a = ~0;			// Sequence of 1s
	 * 	int b = a « (p+1); 	// Sequence of 1s followed by p+1 zeros.
	 * 	n &= b; 	// Clears bits 0 through p.
	 * 
	 * Steps 4: Insert c1 + 1 ones immediately to the right of position p.
	 * 1	0	0	1	1	1	0	0	0	0	0	0	0	0
	 * 13	12	11	10	9	8	7	6	5	4	3	2	1	0
	 * Note that since p = c1 + c0,the (c1 + 1) ones will be followed by (c0 - 1) zeros.
	 * We can do this as follows:
	 * 	int a = 1 « (c1 + 1); 	// 0s with 1 at position (c1 + 1)
	 * 	int b = a - 1; 			// 0s followed by c1 + 1 ones
	 * 	int c = b « (c0 - 1); 	// c1+1 ones followed by C0-1 zeros, n |= c;
	 * */
	int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		
		if (temp == 0)	return -1;
		
		while (((temp & 1) == 0) && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		
		int p = c0 + c1;	// position of rightmost non-trailing one
		n &= ((~0) << (p + 1));	// clears from bit p onwards
		int mask = (1 << (c1 + 1)) - 1;	// Sequence of (c1+1) ones
		n |= mask << (c0 - 1);
		
		return n;
	}

	/*
	 * Arithmetic Approach to Get Next Number
	 * If c0 is the number of trailing zeros, c1 is the size of the one block immediately following, and p = c0 + c1, we can word our solution from earlier as follows:
	 * 1. Set the pth bit to 1
	 * 2. Set all bits following p to 0
	 * 3. Set bits 0 through c1 -1 to l.
	 * A quick and dirty way to perform steps 1 and 2 is to set the trailing zeros to 1 (giving us*/
}

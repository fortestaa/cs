package chapter5;

import java.util.ArrayList;

/**
 * 5.7
 * An array A contains all the integers from 0 through n, except for one number which is missing.
 * In this problem, we cannot access an entire integer in A with a single operation.
 * The elements of A are represented in binary, and the only operation we can use to access them is "fetch the jth bit of Afi]," which takes constant time.
 * Write code to find the missing integer. Can you do it in 0(n) time?
 * */
public class FindMissingNumberInRange {
	public int findMissing(ArrayList<BitInteger> array) {
		return findMissing(array, 0);
	}
	
	public int findMissing(ArrayList<BitInteger> input, int column) {
		if (column >= BitInteger.INTEGER_SIZE) {	// we're done
			return 0;
		}
		ArrayList<BitInteger> oneBits =
				new ArrayList<BitInteger>(input.size() / 2);
		ArrayList<BitInteger> zeroBits = 
				new ArrayList<BitInteger>(input.size() / 2);
		
		for (BitInteger t : input) {
			if (t.fetch(column) == 0) {
				zeroBits.add(t);
			} else {
				oneBits.add(t);
			}
		}
		if (zeroBits.size() <= oneBits.size()) {
			int v = findMissing(zeroBits, column + 1);
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBits, column + 1);
			return (v << 1) | 1;
		}
	}
}

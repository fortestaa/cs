package chapter5;

/*
 * 5.2
 * Given a real number between 0 and 1 (e.g.,0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."
 * */
public class PrintBinary {
	/*
	 * NOTE: When otherwise ambiguous, we'll use the subscripts x_2 and x_10 to indicate whether x is in base 2 or base 10.
	 * First, let's start off by asking ourselves what a non-integer number in binary looks like. 
	 * By analogy to a decimal number, the binary number 0.1012 would look like: 
	 * 0.101_2 =1*(1/2^1)+0*(1/2^2)+1*(1/2^3).
	 * To print the decimal part, we can multiply by 2 and check if 2n is greater than or equal to 1. 
	 * This is essentially "shifting" the fractional sum. That is:
	 * r = 2_10 * n = 2_10 * 0.101_2 = 1 * (1/2^0) + 0 * (1/2^1) + 1 * (1/2^2) = 1.01_2
	 * If r >= 1, then we know that n had a 1 right after the decimal point.
	 * By doing this continuously, we can check every digit.
	 * */
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			// Setting a limit on length: 32 characters
			if (binary.length() >= 32) {
				return "ERROR";
			}
			
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	/*
	 * Alternatively, rather than multiplying the number by two and comparing it to 1,
	 * we can compare the number to .5, then .25, and so on. The code below demonstrates this approach.
	 * */
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			// Setting a limit on length: 32 characters
			if (binary.length() > 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}
}
/*
 * Both approaches are equally good; it just depends on which approach you feel most comfortable with.
 * Either way, you should make sure to prepare thorough test cases for this problem—and to actually run through them in your interview.
*/

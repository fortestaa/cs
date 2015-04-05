package Chapter1_Array_String;

/**
 * 9. Valid Number
 * Code it now: https://oj.leetcode.com/problems/valid-number/

 * Question:
 * Validate if a given string is numeric. Some examples:
 * "0"->true "0.1"->true "abc"->false
 * Example Questions Candidate Might Ask:
 * Q: How to account for whitespaces in the string?
 * A: When deciding if a string is numeric, ignore both leading and trailing whitespaces.
 * Q: Should I ignore spaces in between numbers – such as “1 1”?
 * A: No, only ignore leading and trailing whitespaces. “1 1” is not numeric.
 * Q: If the string contains additional characters after a number, is it considered valid?
 * A: No. If the string contains any non-numeric characters (excluding whitespaces and decimal point), it is not numeric.
 * Q: Is it valid if a plus or minus sign appear before the number? A: Yes. “+1” and “-1” are both numeric.
 * Q: Should I consider only numbers in decimal? How about numbers in other bases such as hexadecimal (0xFF)?
 * A: Only consider decimal numbers. “0xFF” is not numeric.
 * Q: Should I consider exponent such as “1e10” as numeric?
 * A: No. But feel free to work on the challenge that takes exponent into consideration. (The Online Judge problem does take exponent into account.)
 */
public class Valid_Number {
	public boolean isNumber(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i)))	i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))	i++;
		boolean isNumeric = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < n && Character.isWhitespace(s.charAt(i)))	i++;
		return isNumeric && i == n;
	}
	/*
	 * Solution:
	 * This problem is very similar to Question [8. String to Integer (atoi)]. 
	 * Due to many corner cases, it is helpful to break the problem down to several components that can be solved individually.
	 * A string could be divided into these four substrings in the order from left to right:
	 * 	s1. Leading whitespaces (optional).
	 * 	s2. Plus (+) or minus (–) sign (optional). 
	 * 	s3. Number.	
	 * 	s4. Optional trailing whitespaces (optional).
	 * We ignore s1, s2, s4 and evaluate whether s3 is a valid number. We realize that a number could either be a whole number or a decimal number. 
	 * For a whole number, it is easy: We evaluate whether s3 contains only digits and we are done.
	 * On the other hand, a decimal number could be further divided into three parts:
	 * 	a. Integer part
	 * 	b. Decimal point
	 * 	c. Fractional part
	 * The integer and fractional parts contain only digits. For example, the number “3.64” has integer part (3) and fractional part (64). 
	 * Both of them are optional, but at least one of them must present. For example, a single dot ‘.’ is not a valid number, but “1.”, “.1”, and “1.0” are all valid.
	 * Please note that “1.” is valid because it implies “1.0”.
	 * By now, it is pretty straightforward to translate the requirements into code, where the main logic to determine if s3 is numeric from line 6 to line 17.
	 */
	
	/*
	 * Further Thoughts:
	 * A number could contain an optional exponent part, which is marked by a character ‘e’ followed by a whole number (exponent). 
	 * For example, “1e10” is numeric. Modify the above code to adapt to this new requirement.
	 * This is pretty straightforward to extend from the previous solution. The added block of code is highlighted as below.
	 */
	public boolean isNumber2(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i)))	i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))	i++;
		boolean isNumeric = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		//////////////////////////////////////////////////////added//////////////////////////////////////////////////////
		if (isNumeric && i < n && s.charAt(i) == 'e') {
			i++;
			isNumeric = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))	i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		//////////////////////////////////////////////////////added//////////////////////////////////////////////////////
		while (i < n && Character.isWhitespace(s.charAt(i)))	i++;
		return isNumeric && i == n;
	}
}
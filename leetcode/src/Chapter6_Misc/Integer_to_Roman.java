package Chapter6_Misc;

/**
 * 36. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Question:
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Hint:
 * What is the range of the numbers?
 */
public class Integer_to_Roman {

	/**
	 * Solution:
	 * Roman Literal	Decimal
	 * I				1
	 * V				5
	 * X				10
	 * L				50
	 * C				100
	 * D				500
	 * M				1000
	 * Table 1: Roman literals and its decimal representations.[69]
	 * First, let’s understand how to read roman numerals. The rule of roman numerals is simple: Symbols are placed from left to right starting with the largest, and we add the values according to the additive notation.
	 * However, there is an exception to avoid four symbols being repeated in succession, also known as the subtractive notation.
	 * 
	 * The additive notation:
	 * We combine the symbols and add the values. For example, III is three ones, which is 3. Another example XV means ten followed by a five, which is 15.
	 * 
	 * The subtractive notation:
	 * Four characters are avoided being repeated in succession (such as IIII). Instead, the symbol I could appear before V and X to signify 4 (IV) and 9 (IX) respectively. Using the same pattern, we observe that X could appear before L and C to signify 40 (XL) and 90 (XC) respectively. The same pattern could be applied to C that is placed before D and M.
	 * With our understanding of roman numerals, we have to decide how to extract the digits from the integer. Should we extract from right to left (from the least significant digit) or from left to right (from the most significant digit)?
	 * If digits are extracted from right to left, we have to append the symbols in reversed order. Extracting digits from left to right seem more natural. It is also slightly trickier but not if we know the maximum number of digits could the number have in advanced, which we do – The number is within the range from 1 to 3999.
	 * Using the additive notation, we convert to roman numerals by breaking it so each chunk can be represented by the symbol entity. For example, 11 = 10 + 1 = “X” + “I”. Similarly, 6 = 5 + 1 = “V” + “I”. Let’s take a look of an example which uses the subtractive notation: 49 = 40 + 9 = “XL” + “IX”. Note that we treat “XL” and “IX” as one single entity to avoid dealing with these special cases to greatly simplify the code.
	 */
	private static final int[] values = {
		1000, 900, 500, 400,
		100,  90,  50,  40,
		10,   9,   5,   4,
		1
	};
	
	private static final String[] symbols = {
		"M", "CM", "D", "CD",
		"C", "XC", "L", "XL",
		"X", "IX", "V", "IV",
		"I"
	};
	
	public String intToRoman(int num) {
		StringBuilder roman = new StringBuilder();
		int i = 0;
		while (num > 0) {
			int k = num / values[i];
			for (int j = 0; j < k; j++) {
				roman.append(symbols[i]);
				num -= values[i];
			}
			i++;
		}
		return roman.toString();
	}
	/*
	 * Follow up:
	 * Implement Roman to Integer. See Question [37. Roman to Integer].
	 */
}
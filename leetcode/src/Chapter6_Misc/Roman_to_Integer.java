package Chapter6_Misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 37. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Question:
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman_to_Integer {

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
	 * Table 2: Roman literals and its decimal representations.
	 * Let’s work through some examples. Assume the input is “VII”, using the [additive notation], we could simply add up each roman literal, ‘V’ + ‘I’ + ‘I’ = 5 + 1 + 1 = 7.
	 * Now let’s look at another example input “IV”. Now we need to use the [subtractive notation]. We first look at ‘I’, and we add 1 to it. Then we look at ‘V’ and since a smaller roman literal ‘I’ appears before it, we need to subtract ‘I’ from ‘V’. Remember that we already added another ‘I’ before it, so we need to subtract a total of two one’s from it.
	 * Below is a more complex example that involves both additive and subtractive notation: “MXCVI”.
	 * Roman literals from left to right	Accumulated total
	 * M									1000
	 * MX									1000 + 10 = 1010
	 * MXC									1010 + (100 – 2 * 10) = 1010 + 80 = 1090
	 * MXCV									1090 + 5 = 1095
	 * MXCVI								1095 + 1 = 1096
	 * Table 3: Step by step calculation of roman numeral "MXCVI".
	 */
	private Map<Character, Integer> map = 
			new HashMap<Character, Integer>() {{
				put('I', 1);  put('V', 5);   put('X', 10);
				put('L', 50); put('C', 100); put('D', 500);
				put('M', 1000);
			}};
			
	public int romanToInt(String s) {
		int prev = 0, total = 0;
		for (char c : s.toCharArray()) {
			int curr = map.get(c);
			total += (curr > prev) ? (curr - 2 * prev) : curr;
			prev = curr;
		}
		return total;
	}
}
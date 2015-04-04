package easy;

/**
 * Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 
 * B -> 2 
 * C -> 3 
 * ... 
 * Z -> 26 
 * AA -> 27 
 * AB -> 28
 */
public class Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0)	return 0;
		
		int result = 0;
		for (char c : s.toCharArray()) {
			int i = c - 'A' + 1;
			result = result * 26 + i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Excel_Sheet_Column_Number e = new Excel_Sheet_Column_Number();
		System.out.println(e.titleToNumber("A"));
		System.out.println(e.titleToNumber("Z"));
		System.out.println(e.titleToNumber("AB"));
	}
}

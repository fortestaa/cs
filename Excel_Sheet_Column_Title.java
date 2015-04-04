package easy;

/**
 * Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 *  1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {
		if (n <= 0)	return "";
		
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			int r = n % 26;
			sb.insert(0, (char)('A' + r));
			n = n / 26;
		}
		return sb.toString();
	}
	//https://github.com/FreeTymeKiyan/LeetCode-Sol-Res/blob/master/Easy/ExcelSheetColTitle.java
	
	public static void main(String[] args) {
		Excel_Sheet_Column_Title e = new Excel_Sheet_Column_Title();
		System.out.println(e.convertToTitle(26));
		System.out.println(e.convertToTitle(27));
		System.out.println(e.convertToTitle(28));
		System.out.println(e.convertToTitle(52));
	}
}

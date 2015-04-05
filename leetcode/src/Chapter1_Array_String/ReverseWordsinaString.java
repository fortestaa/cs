package Chapter1_Array_String;

/**
 * 6. Reverse Words in a String
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/

 * Question:
 * Given an input string s, reverse the string word by word.
 * For example, given s = "the sky is blue", return "blue is sky the".
 * 
 * Example Questions Candidate Might Ask:
 * Q: What constitutes a word?
 * A: A sequence of non-space characters constitutes a word.
 * Q: Does tab or newline character count as space characters?
 * A: Assume the input does not contain any tabs or newline characters.
 * Q: Could the input string contain leading or trailing spaces?
 * A: Yes. However, your reversed string should not contain leading or trailing spaces.
 * Q: How about multiple spaces between two words?
 * A: Reduce them to a single space in the reversed string.
 */
public class ReverseWordsinaString {
/*
 * O(n) runtime, O(n) space: 
 * a two-pass solution: 
 * First pass to split the string by spaces into an array of words, 
 * then second pass to extract the words in reversed order.
 * 
 * We can do better in one-pass.
 * While iterating the string in reverse order, we keep track of a word’s begin and end position. 
 * When we are at the beginning of a word, we append it.
 */
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}
	
	/*
	 * Follow up:
	 * If the input string does not contain leading or trailing spaces and the words are separated by a single space, 
	 * could you do it in-place without allocating extra space? See Question [7. Reverse Words in a String II].
	 */
}
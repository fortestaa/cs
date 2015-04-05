package Chapter1_Array_String;

/**
 * Question:
 * Similar to Question [6. Reverse Words in a String], but with the following constraints:
 * “The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinaStringII {
/*
 * O(n) runtime, O(1) space – In-place reverse:
 * Let us indicate the ith word by wi and its reversal as wi′. Notice that when you reverse a word twice, you get back the original word. That is, (wi′)′ = wi.
 * The input string is w1 w2 ... wn. If we reverse the entire string, it becomes wn′ ... w2′ w1′. Finally, we reverse each individual word and it becomes wn ... w2 w1.
 * Similarly, the same result could be reached by reversing each individual word first, and then reverse the entire string.
 */
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	
	private void reverse(char[] s, int begin, int end) {
		for (int i = 0; i < (end - begin) / 2; i++) {
			char temp = s[begin + i];
			s[begin + i] = s[end - i - 1];
			s[end - i - 1] = temp;
		}
	}
	
	/*
	 * Challenge 1:
	 * Implement the two-pass solution without using the library’s split function.
	 * Challenge 2:
	 * Rotate an array to the right by k steps in-place without allocating extra space. 
	 * For instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3].
	 * */
}
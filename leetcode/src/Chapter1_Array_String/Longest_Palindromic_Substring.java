package Chapter1_Array_String;

/**
 * 13. Longest Palindromic Substring
 * Code it now: https://oj.leetcode.com/problems/longest-palindromic-substring/
 * 
 * Question:
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Hint:
 * First, make sure you understand what a palindrome means. A palindrome is a string which reads the same in both directions. For example, “aba” is a palindome, “abc” is not.
 */
public class Longest_Palindromic_Substring {

	/**
	 * O(n3) runtime, O(1) space – Brute force:
	 * The obvious brute force solution is to pick all possible starting and ending positions for a substring, and verify if it is a palindrome.
	 * There are a total of such substrings (excluding the trivial solution where a character itself is a palindrome).
	 * Since verifying each substring takes O(n) time, the run time complexity is O(n^3).
	 */
	
	/**
	 * O(n^2) runtime, O(n) space – Dynamic programming:
	 * To improve over the brute force solution from a DP approach, first think how we can avoid unnecessary re-computation in validating palindromes.
	 * Consider the case “ababa”. If we already knew that “bab” is a palindrome, it is obvious that “ababa” must be a palindrome since the two left and right end letters are the same.
	 * Stated more formally below:
	 * Define P[ i, j ] ← true iff the substring Si ... Sj is a palindrome, otherwise false. Therefore,
	 * P[ i, j ] ← ( P[ i+1, j-1 ] and Si = Sj )
	 * The base cases are:
	 * P[ i, i ] ← true
	 * P[ i, i+1 ] ← ( Si = Si+1 )
	 * This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...
	 * This gives us a runtime complexity of O(n^2) and uses O(n^2) space to store the table. Additional exercise:
	 * Could you improve the above space complexity further and how?
	 */
	
	/**
	 * O(n^2) runtime, O(1) space – Simpler solution:
	 * In fact, we could solve it in O(n^2) time using only constant space.
	 * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n – 1 such centers.
	 * You might be asking why there are 2n – 1 but not n centers? 
	 * The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as “abba”) and its center are between the two ‘b’s.
	 * Since expanding a palindrome around its center could take O(n) time, the overall complexity is O(n^2).
	 */
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	/**
	 * O(n) runtime, O(n) space – Manacher’s algorithm:
	 * There is even an O(n) algorithm called Manacher's algorithm, explained here in detail. 
	 * However, it is a non-trivial algorithm, and no one expects you to come up with this algorithm in a 30 minutes coding session. 
	 * But, please go ahead and understand it, I promise it will be a lot of fun.
	 */
}
/*
 * A common mistake:
 * Some people will be tempted to come up with a quick solution, which is unfortunately flawed (however can be corrected easily):
 * Reverse S and become S’. Find the longest common substring between S and S’, which must also be the longest palindromic substring.
 * This seemed to work, let’s see some examples below.
 * For example, S = “caba”, S’ = “abac”.
 * The longest common substring between S and S’ is “aba”, which is the answer.
 * Let’s try another example: S = “abacdfgdcaba”, S’ = “abacdgfdcaba”.
 * The longest common substring between S and S’ is “abacd”. Clearly, this is not a valid palindrome.
 * We could see that the longest common substring method fails when there exists a reversed copy of a non-palindromic substring in some other part of S.
 * To rectify this, each time we find a longest common substring candidate, we check if the substring’s indices are the same as the reversed substring’s original indices.
 * If it is, then we attempt to update the longest palindrome found so far; if not, we skip this and find the next candidate.
 * This gives us an O(n^2) DP solution which uses O(n^2) space (could be improved to use O(n) space). Please read more about Longest Common Substring here.
 */
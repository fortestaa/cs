package Chapter1_Array_String;

import java.util.Arrays;

/**
 * 11. Longest Substring with At Most Two Distinct Characters
 * 
 * Question:
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3.
 * For “bbbbb” the longest substring is “b”, with the length of 1.
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters {

	/**
	 * O(n) runtime, O(1) space – Two iterations:
	 * How can we look up if a character exists in a substring instantaneously? The answer is to use a simple table to store the characters that have appeared.
	 * Make sure you communicate with your interviewer if the string can have characters other than ‘a’–‘z’. (ie, Digits? Upper case letter? Does it contain ASCII characters only? Or even unicode character sets?)
	 * The next question is to ask yourself what happens when you found a repeated character? For example, if the string is “abcdcedf”, what happens when you reach the second appearance of ‘c’?
	 * When you have found a repeated character (let’s say at index j), it means that the current substring (excluding the repeated character of course) is a potential maximum, so update the maximum if necessary.
	 * It also means that the repeated character must have appeared before at an index i, where i is less than j.
	 * Since you know that all substrings that start before or at index i would be less than your current maximum, you can safely start to look for the next substring with head which starts exactly at index i + 1.
	 * Therefore, you would need two indices to record the head and the tail of the current substring. Since i and j both traverse at most n steps, the worst case would be 2n steps, which the runtime complexity must be O(n).
	 * Note that the space complexity is constant O(1), even though we are allocating an array. This is because no matter how long the string is, the size of the array stays the same at 256.
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1))	continue;
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			j = k - 1;
		}
		return Math.max(s.length() - i, maxLen);
	}
	/*
	 * What if the character set could contain unicode characters that is out of ascii’s range?
	 * We could modify the above solution to use a Set instead of a simple boolean array of size 256.
	 */
	
	/**
	 *Further Thoughts:
	 *Although the above method works fine, it could not be easily generalized to the case where T contains at most k distinct characters.
	 *The key is when we adjust the sliding window to satisfy the invariant, we need a counter of the number of times each character appears in the substring.
	 **/
	public int lengthOfLongestSubstring2(String s) {
		int[] count = new int[256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0)	numDistinct++;
			count[s.charAt(j)]++;
			while (numDistinct > 2) {
				count[s.charAt(i)]--;
				if (count[s.charAt(i)] == 0)	numDistinct--;
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
}
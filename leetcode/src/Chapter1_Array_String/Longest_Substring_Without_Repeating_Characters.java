package Chapter1_Array_String;

import java.util.Arrays;

/**
 * 10. Longest Substring Without Repeating Characters
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters
 * 
 * Question:
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is "ece" which its length is 3.
 */
public class Longest_Substring_Without_Repeating_Characters {

	/**
	 * First, we could simplify the problem by assuming that S contains two or more distinct characters, which means T must contain exactly two distinct characters.
	 * The brute force approach is O(n^3) where n is the length of S. 
	 * We can form every possible substring, and for each substring insert all characters into a Set which the Set’s size indicating the number of distinct characters.
	 * This could be easily improved to O(n^2) by reusing the same Set when adding a character to form a new substring.
	 * The trick is to maintain a sliding window that always satisfies the invariant where there are always at most two distinct characters in it.
	 * When we add a new character that breaks this invariant, how can we move the begin pointer to satisfy the invariant?
	 * Using the above example, our first window is the substring “abba”. When we add the character ‘c’ into the sliding window, it breaks the invariant.
	 * Therefore, we have to readjust the window to satisfy the invariant again. The question is which starting point to choose so the invariant is satisfied.
	 * Let’s look at another example where S = “abaac”. We found our first window “abaa”. When we add ‘c’ to the window, the next sliding window should be “aac”.
	 * This method iterates n times and therefore its runtime complexity is O(n). We use three pointers: i, j, and k.
	 * */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
	/*
	 * What if the character set could contain unicode characters that is out of ascii’s range?
	 * We could modify the above solution to use a Set instead of a simple boolean array of size 256.
	 */
	
	/**
	 * O(n) runtime, O(1) space – Single iteration:
	 * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps.
	 * Instead of using a table to tell if a character exists or not, we could define a mapping of the characters to its index.
	 * Then we can skip the characters immediately when we found a repeated character.
	 */
	public int lengthOfLongestSubstring2(String s) {
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
}
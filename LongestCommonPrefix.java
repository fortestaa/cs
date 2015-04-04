package easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null)	return null;
		if (strs.length == 0)	return "";
		if (strs.length == 1)	return strs[0];
		
		String word = strs[0];
		int prefixLength = word.length();
		
		for (int i = 1; i < strs.length; i++) {
			String nextWord = strs[i];
			prefixLength = Math.min(prefixLength, nextWord.length());
			for (int j = 0; j < prefixLength; j++) {
				if (word.charAt(j) != nextWord.charAt(j)) {
					prefixLength = j;
					break;
				}
			}
		}
		
		return word.substring(0, prefixLength);
	}
	//https://github.com/FreeTymeKiyan/LeetCode-Sol-Res/blob/master/Easy/LongestCommonPrefix.java
}

package chapter1;

/*
 * 1.3
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 * */
public class RemoveStringDuplicates {
	/*
	 * First, ask yourself, what does the interviewer mean by an additional buffer? 
	 * Can we use an additional array of constant size?
	 * */
	
	/*Algorithm—No (Large) Additional Memory:
		1. For each character, check if it is a duplicate of already found characters.
		2. Skip duplicate characters and update the non duplicate characters.
		Time complexity is O(N^2).
	 */
	public static void removeDuplicates(char[] str) {
		if (str == null)	return;
		int len = str.length;
		if (len < 2)	return;
		
		int tail = 1;
		
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])	break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
	/*Test Cases:
	 * 1. String does not contain any duplicates, e.g.: abcd
	 * 2. String contains all duplicates, e.g.: aaaa
	 * 3. Null string
	 * 4. String with all continuous duplicates, e.g.: aaabbb
	 * 5. String with non-contiguous duplicate, e.g.: abababa
	*/
	
	/*Algorithm—With Additional Memory of Constant Size*/
	public static void removeDuplicatesEff(char[] str) {
		if (str == null)	return;
		int len = str.length;
		if (len < 2) return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 0; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
	/*Test Cases:
	 * 1. String does not contain any duplicates, e.g.: abcd
	 * 2. String contains all duplicates, e.g.: aaaa
	 * 3. Null string
	 * 4. Empty string
	 * 5. String with all continuous duplicates, e.g.: aaabbb
	 * 6. String with non-contiguous duplicates, e.g.: abababa
	 * */
}

package easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class Count_and_Say {
	public String countAndSay(int n) {
		String res = "1";
		while (--n > 0) {
			StringBuilder sb = new StringBuilder();
			char[] prev = res.toCharArray();
			for (int i = 0; i < prev.length; i++) {
				int count = 1;
				while (i + 1 < prev.length && prev[i] == prev[i + 1]) {
					count++;
					i++;
				}
				sb.append(count).append(prev[i]);
			}
			res = sb.toString();
		}
		return res;
	}k

	/*public static void main(String[] args) {
		Count_and_Say c = new Count_and_Say();
		System.out.println(c.countAndSay(1));
		System.out.println(c.countAndSay(2));
		System.out.println(c.countAndSay(3));
		System.out.println(c.countAndSay(4));
		System.out.println(c.countAndSay(5));
		System.out.println(c.countAndSay(6));
	}*/
}

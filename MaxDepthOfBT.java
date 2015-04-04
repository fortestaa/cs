package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element 
 * https://leetcode.com/problems/majority-element/
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */
public class MajorityElement {
	/**
     * Go through the array, assign maj ele if count is 0
     * Add 1 to count if same element, otherwise minus 1
     */
	public int majorityElement(int[] num) {
		int maj = num[0];
		for (int count = 0, i = 0; i < num.length && count <= num.length / 2; i++) {
			if (count == 0) {
				maj = num[i];
				count++;
			}
			else	count = num[i] == maj ? count + 1 : count - 1;
		}
		return maj;
    }

	// mine
	public int majorityElement0(int[] num) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int minSize = num.length / 2;
        if (num.length == 1)    return num[0];
		for (int i = 0; i < num.length; i++) {
			if (count.containsKey(num[i]))  {
			    int c = count.get(num[i]);
			    c += 1;
			    if (c > minSize)
			        return num[i];
				count.put(num[i], c);
			} else {
				count.put(num[i], 1);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int a[] = {-1,1,1,1,2,1};
		int b[] = {8,8,7,7,7};
		System.out.println(m.majorityElement(a));
		System.out.println(m.majorityElement(b));
	}
}

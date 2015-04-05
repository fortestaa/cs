package Chapter1_Array_String;

import java.util.HashMap;
import java.util.Map;


/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * 
 * Question:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 */
public class TwoSum {
	/*
	 * O(n2) runtime, O(1) space – Brute force:
	 * The brute force approach is simple. Loop through each element x and find if there is another value that equals to target – x.
	 * As finding another value requires looping through the rest of array, its runtime complexity is O(n^2).
	 * */
	
	/*
	 * O(n) runtime, O(n) space – Hash table:
	 * We could reduce the runtime complexity of looking up a value to O(1) using a hash map that maps a value to its index.
	 * */
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if (map.containsKey(target - x)) {
				return new int[] { map.get(target - x) + 1, i + 1 };
			}
			map.put(x,  i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
/*
 * Follow up:
 * What if the given input is already sorted in ascending order?
 * See Question [2. Two Sum II – Input array is sorted].
 * */
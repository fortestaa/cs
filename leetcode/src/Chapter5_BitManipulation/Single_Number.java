package Chapter5_BitManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 33. Single Number
 * https://leetcode.com/problems/single-number/
 * 
 * Question:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Example Questions Candidate Might Ask:
 * Q: Does the array contain both positive and negative integers? 
 * A: Yes.
 * Q: Could any element appear more than twice? 
 * A: No.
 */
public class Single_Number {
	
	/**
	 * We could use a map to keep track of the number of times an element appears.
	 * In a second pass, we could extract the single number by consulting the hash map.
	 * As a hash map provides constant time lookup, the overall complexity is O(n), where n is the total number of elements.
	 */
	public int singleNumber1(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : A) {
			int count = map.containsKey(x) ? map.get(x) : 0;
			map.put(x, count + 1);
		}
		for (int x : A) {
			if (map.get(x) == 1) {
				return x;
			}
		}
		throw new IllegalArgumentException("No single element");
	}
	/*
	 * Although the map approach works, we are not taking advantage of the “every elements appears twice except one” property. Could we do better in one pass?
	 */
	
	/**
	 * How about inserting the elements into a set instead?
	 * If an element already exists, we discard the element from the set knowing that it will not appear again.
	 * After the first pass, the set must contain only the single element.
	 */
	public int singleNumber2(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int x : A) {
			if (set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		return set.iterator().next();
	}
	/*
	 * The set is pretty efficient and runs in one pass. However, it uses extra space of O(n).
	 */
	
	/**
	 * XOR-ing a number with itself is zero.
	 * If we XOR all numbers together, it would effectively cancel out all elements that appear twice leaving us with only the single number.
	 * As the XOR operation is both commutative and associative, the order in how you XOR them does not matter.
	 */
	public int singleNumber(int[] A) {
		int num = 0;
		for (int x : A) {
			num ^= x;
		}
		return num;
	}
	/*
	 * Further Thoughts:
	 * Let us change the question a little: “If every element appears even number of times except for one element that appears odd number of times, find that one element”, would the XOR approach work? Why?
	 */
}
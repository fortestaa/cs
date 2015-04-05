package Chapter8_DynamicProgramming;

/**
 * 42. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * Question:
 * You are climbing a staircase. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Climbing_Stairs {

	/**
	 * O(n) runtime, O(1) space – Dynamic programming: 
	 * This is a classic Dynamic Programming problem. 
	 * Define: f(n) = number of ways you can climb to the nth step.
	 * To reach to the nth step, you have only two choices:
	 * 	1. Advance one step from the n – 1th step.
	 * 	2. Advance two steps from the n – 2th step.
	 * Therefore, f(n) = f(n – 1) + f(n – 2), which is the exact same recurrence formula defined by the Fibonacci sequence (with different base cases, though).
	 * Set base cases f(1) = 1, f(2) = 2 and you are almost done.
	 * Now, we could calculate f(n) easily by storing previous values in an one dimension array and work our way up to n. Heck, we can even optimize this further by storing just the previous two values.
	 */
	public int climbStairs(int n) {
		int p = 1, q = 1;
		for (int i = 2; i <= n; i++) {
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
	/*
	 * Combinatorics:
	 * Interestingly, this problem could also be solved using combinatorics.
	 * Warning: Math-y stuff ahead, feel free to skip this section if you are not interested.
	 * For example, let's assume n = 6.
	 * Let: x = number of 1's, y = number of 2's.
	 * We could reach the top using one of the four combinations below:
	 * x	y
	 * 6	0	=> 1) Six single steps.
	 * 4	1	=> 2) Four single steps and one double step.
	 * 2	2	=> 3) Two single steps and two double steps.
	 * 0	3	=> 4) Three double steps.
	 * For the first combination pair (x,y) = (6,0), there's obviously only one way of arranging six single steps.
	 * For the second combination pair (4,1), there's five ways of arranging (think of it as slotting the double step between the single steps).
	 * Similarly, there are six ways C(4,2) and one way of arranging the third and fourth combination pairs respectively.
	 * Generally, for pair (x,y), there are a total of C(x+y, y) = (x+y)! / (x!y!) ways of arranging the 1's and 2's.
	 * The total number of possible ways is the sum of all individual terms,
	 * f(6) = 1 + 5 + 6 + 1 = 13.
	 * Generalizing for all n's (including odd n), 
	 * f(n) = C(n,0) + C(n-1, 1) + C(n-2, 2) + ... + C(ceil(n/2), floor(n/2))
	 */
}
package Chapter3_LinkedList;

import leetcode.datastructure.ListNode;

/**
 * 21. Add Two Numbers
 * Code it now: https://oj.leetcode.com/problems/add-two-numbers/
 * 
 * Question:
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contains a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2->4->3) + (5->6->4) 
 * Output: 7->0->8
 *
 */
public class Add_Two_Numbers {

	/**
	 * Solution:
	 * Keep track of the carry using a variable and simulate digits-by-digits sum from the head of list, which contains the least-significant digit.
	 * Take extra caution of the following cases:
	 * - When one list is longer than the other.
	 * - The sum could have an extra carry of one at the end, which is easy to forget. (e.g., (9->9) + (1) = (0->0->1))
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null && q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int digit = carry + x + y;
			carry = digit / 10;
			curr.next = new ListNode(digit % 10);
			curr = curr.next;
			if (p != null)	p = p.next;
			if (q != null)	q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}
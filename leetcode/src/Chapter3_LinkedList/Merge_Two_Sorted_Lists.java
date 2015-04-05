package Chapter3_LinkedList;

import leetcode.datastructure.ListNode;

/**
 * 20. Merge Two Sorted Lists
 * Code it now: https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Question:
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 */
public class Merge_Two_Sorted_Lists {

	/**
	 * Solution:
	 * We insert a dummy head before the new list so we don’t have to deal with special cases such as initializing the new list’s head.
	 * Then the new list’s head could just easily be returned as dummy head’s next node.
	 * Using dummy head allows you to write simpler code and adds as a powerful tool to your interview arsenal.
	 * To see more examples of dummy head usage, please see these questions: [21. Add Two Numbers], [22. Swap Nodes in Pairs], and [23. Merge K Sorted Linked Lists].
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null)	p.next = l1;
		if (l2 != null)	p.next = l2;
		return dummyHead.next;
	}
}
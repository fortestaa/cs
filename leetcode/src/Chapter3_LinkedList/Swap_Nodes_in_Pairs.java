package Chapter3_LinkedList;

import leetcode.datastructure.ListNode;

/**
 * 22. Swap Nodes in Pairs
 * Code it now: https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Question:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * Example Questions Candidate Might Ask:
 * Q: What if the number of nodes in the linked list has only odd number of nodes?
 * A: The last node should not be swapped.
 *
 */
public class Swap_Nodes_in_Pairs {

	/**
	 * Solution:
	 * Let’s assume p, q, r are the current, next, and next’s next node.
	 * We could swap the nodes pairwise by adjusting where it’s pointing next:
	 * q.next = p;
	 * p.next = r;
	 * The above operations transform the list from { p->q->r->s } to { q->p->r->s }.
	 * If the next pair of nodes exists, we should remember to connect p’s next to s.
	 * Therefore, we should record the current node before advancing to the next pair of nodes.
	 * To determine the new list’s head, you look at if the list contains two or more elements.
	 * Basically, these extra conditional statements could be avoided by inserting an extra node (also known as the dummy head) to the front of the list.
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode prev = dummy;
		while (p != null && p.next != null) {
			ListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
}
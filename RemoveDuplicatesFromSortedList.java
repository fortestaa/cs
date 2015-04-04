package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)   return null;
		Map<Integer, Integer> map = new HashMap<>();
		ListNode prev = head, node = head.next;
		map.put(head.val, head.val);
		while (node != null) {
			if (map.containsKey(node.val)) {	// to delete
				prev.next = node.next;
			} else {
				map.put(node.val, node.val);
				prev = node;
			}
			node = node.next;
		}
		return head;
	}
}

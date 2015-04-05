package chapter2;

import java.util.Hashtable;

/*
 * 2.3
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
*/		
public class DeleteNode {
	/*
	 * The solution to this is to simply copy the data from the next node into this node and then delete the next node.
	 * */
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;	// Failure
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}

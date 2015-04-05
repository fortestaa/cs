package Chapter3_LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 24. Copy List with Random Pointer
 * Code it now: https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Question:
 * A linked list is given such that each node contains an additional random pointer that could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 */
public class Copy_List_with_Random_Pointer {

	/**
	 * Solution:
	 * Cloning a linked list without an additional random pointer is easy to solve.
	 * The trickier part however, is to clone the random list node structure.
	 * Figure 1: Linked list that has both next and random pointers. [p44]
	 * 
	 * O(n^2) runtime, O(n) space – Brute force:
	 * To get started, it is helpful to label each individual node with an index.
	 * According to the above list, node 0’s random points to node 1, node 1’s random point to node 0, and node 2’s random points to itself, node 2.
	 * We could rebuild the structure assume we have the above connections.
	 * As we know that node 0 random points to node 1, we need to connect the cloned version from node 0' to node 1'.
	 * We would have to iterate over the list each time to link the nodes and it takes O(n), making the overall time complexity O(n^2).
	 * How do we represent the connection?
	 * We can build a map that maps the original node to its indices. Having this map will allow us to clone the structure.
	 * If we know that node 0’s random points to node 1, we just have to connect them, right? The only issue is connecting them takes O(n) complexity,
	 * because we have to traverse the cloned list to find the node to connect.
	 * 
	 * O(n) runtime, O(n) space – Hash table:
	 * It is now natural to lead to a mapping so we can quickly lookup the node to connect.
	 * We can easily build the map of indices to cloned nodes.
	 * Therefore, we have reduced the complexity to O(1) when connecting the random nodes. This had got us started, although it requires two maps.
	 * On closer inspection, it turns out that the two maps could be shortened into one single map. We just need to map the original node to its random node directly.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode p = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode q = dummy;
		while (p != null) {
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		p = head;
		q = dummy;
		while (p != null) {
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}
		return dummy.next;
	}
	
	/**
	 * O(n) runtime, O(1) space – Modify original structure:
	 * The above algorithm uses extra space O(n), can we not use extra space? What if we eliminate the map?
	 * The only way is to modify the original structure. Imagine if we modify the next node of the original node to point to its own copy.
	 * Now, assume we have the above configuration we could assign the random node pointers of each copy easily with the following code:
	 * 		node.next.random = node.random.next;
	 * To summarize, we need three iterations over the list:
	 * i. Create a copy of each of the original node and insert them in between two original nodes in an alternate fashion.
	 * ii. Assign random pointer of each node copy.
	 * iii. Restore the input to its original configuration.
	 * We have achieved O(n) runtime complexity with using only constant extra space.
	 */
	public RandomListNode copyRandomList2(RandomListNode head) {
		RandomListNode p = head;
		while (p != null) {
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		while (p != null) {
			p.next.random = (p.random != null) ? p.random.next : null;
			p = p.next.next;
		}
		p = head;
		RandomListNode headCopy = (p != null) ? p.next : null;
		while (p != null) {
			RandomListNode copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p != null) ? p.next : null;
		}
		return headCopy;
	}
	
	private class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {
			this.label = x;
		}
	}
}
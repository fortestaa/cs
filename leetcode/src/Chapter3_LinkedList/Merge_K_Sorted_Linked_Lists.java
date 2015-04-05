package Chapter3_LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.datastructure.ListNode;

/**
 * 23. Merge K Sorted Linked Lists
 * Code it now: https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Question: Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 */
public class Merge_K_Sorted_Linked_Lists {

	/**
	 * O(n*k^2) runtime, O(1) space – Brute force: merge a list one by one. For
	 * example, if the lists = [l1, l2, l3, l4], we first merge l1 and l2, then
	 * merge the result with l3, and finally l4. To analyze its time complexity,
	 * we are going to assume there are a total of k lists, and each list is of
	 * size n. There will be a total of k – 1 merge operations. The first merge
	 * operation will be two lists of size n, therefore in the worst case there
	 * could be n + n comparisons. The second merge operation will be two lists
	 * of size 2n and n. Notice that each merge increase the size of the merged
	 * lists by n. Therefore, the total number of comparisons required is 2n +
	 * 3n + 4n + ... + kn = = O(n*k^2).
	 * 
	 * O(nk log k) runtime, O(k) space – Heap: We could use a min heap of size
	 * k. The heap is first initialized with the smallest element from each
	 * list. Then as we extract the nodes out from the heap, we must remember to
	 * insert its next node into the heap. As each insert operation into the
	 * heap costs log(k) and there are a total of nk elements, the total runtime
	 * complexity is O(nk log k). Ignoring the extra space that is used to store
	 * the output list, we only use extra space of O(k) due to the heap.
	 */
	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty())
			return null;
		Queue<ListNode> queue = new PriorityQueue<>(lists.size(),
				listComparator);
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		return dummyHead.next;
	}
	
	/**
	 * O(nk log k) runtime, O(1) space – Divide and conquer using two way merge:
	 * If you still remember how merge sort works, we can use a divide and conquer mechanism to solve this problem.
	 * Here, we apply the merge two lists algorithm from Question [20. Merge Two Sorted Lists].
	 * Basically, the algorithm merges two lists at a time, so the number of lists reduces from: k->k/2->k/4->...->2->1
	 * Similarly, the size of the lists increases from (Note that the lists could subdivide itself at most log(k) times):
	 * 		n->2n->4n->...->2^logk * n
	 * Therefore, the runtime complexity is:
	 * 		k * n + k/2 * 2n + k/4 * 4n + ... + 2^logk *n * 1
	 * 		= nk + nk + nk + ... + nk
	 * 		= nk log k
	 * Since we are implementing this divide and conquer algorithm iteratively, the space complexity is constant at O(1), yay!
	 */
	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists.isEmpty())	return null;
		int end = lists.size() - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}		
		}
		return lists.get(0);
	}
	private ListNode merge2Lists(ListNode l1, ListNode l2) {
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
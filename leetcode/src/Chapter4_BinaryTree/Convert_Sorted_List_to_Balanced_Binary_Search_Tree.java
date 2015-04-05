package Chapter4_BinaryTree;

import leetcode.datastructure.ListNode;
import leetcode.datastructure.TreeNode;

/**
 * 30. Convert Sorted List to Balanced Binary Search Tree
 * Code it now: https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Question:
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Hint:
 * Things get a little more complicated when you have a singly linked list instead of an array. Please note that in linked list, you no longer have random access to an element in O(1) time.
 * How about inserting nodes following the list’s order? If we can achieve this, we no longer need to find the middle element, as we are able to traverse the list while inserting nodes to the tree.
 *
 */
public class Convert_Sorted_List_to_Balanced_Binary_Search_Tree {

	/**
	 * O(n log n) runtime, O(log n) stack space – Brute force:
	 * A naive way is to apply the previous solution from Question [29. Convert Sorted Array to Balanced Binary Search Tree] directly.
	 * In each recursive call, you would have to traverse half of the list’s length to find the middle element.
	 * The run time complexity is clearly O(n log n), where n is the total number of elements in the list.
	 * This is because each level of recursive call requires a total of ￼traversal steps in the list, and there are a total of log(n) number of levels (ie, the height of the balanced tree).
	 * 
	 * O(n) runtime, O(log n) stack space – Bottom-up recursion:
	 * As usual, the best solution requires you to think from another perspective. In other words, we no longer create nodes in the tree using the top-down approach.
	 * We create nodes bottom-up, and assign them to its parents. The bottom-up approach enables us to access the list in its order while creating nodes.
	 * Isn’t the bottom-up approach neat? Each time you are stuck with the top-down approach, give bottom-up a try.
	 * Although bottom-up approach is not the most natural way we think, it is extremely helpful in some cases.
	 * However, you should prefer top-down instead of bottom-up in general, since the latter is more difficult to verify in correctness.
	 * Below is the code for converting a singly linked list to a balanced BST. Please note that the algorithm requires the list’s length to be passed in as the function’s parameters.
	 * The list’s length could be found in O(n) time by traversing the entire list’s once. The recursive calls traverse the list and create tree’s nodes by the list’s order, which also takes O(n) time.
	 * Therefore, the overall run time complexity is still O(n).
	 */
	private ListNode list;
	
	private TreeNode sortedListToBST(int start, int end) {
		if (start > end)	return null;
		int mid = (start + end) / 2;
		TreeNode leftChild = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		int n = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			n++;
		}
		list = head;
		return sortedListToBST(0, n - 1);
	}
}
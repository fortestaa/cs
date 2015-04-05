package Chapter4_BinaryTree;

import leetcode.datastructure.TreeNode;

/**
 * 29. Convert Sorted Array to Balanced Binary Search Tree
 * Code it now: https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Question:
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Hint:
 * This question is highly recursive in nature. Think of how binary search works.
 * Figure 2: An example of a height-balanced tree.
 * A height-balanced tree is a tree whose subtrees differ in height by no more than one and the subtrees are height-balanced, too.
 *
 */
public class Convert_Sorted_Array_to_Balanced_Binary_Search_Tree {

	/**
	 * O(n) runtime, O(log n) stack space – Divide and conquer:
	 * If you would have to choose an array element to be the root of a balanced BST, which element would you pick?
	 * The root of a balanced BST should be the middle element from the sorted array.
	 * You would pick the middle element from the sorted array in each iteration. You then create a node in the tree initialized with this element.
	 * After the element is chosen, what is left? Could you identify the sub-problems within the problem?
	 * There are two arrays left — The one on its left and the one on its right.
	 * These two arrays are the sub-problems of the original problem, since both of them are sorted.
	 * Furthermore, they are subtrees of the current node’s left and right child.
	 * The code below creates a balanced BST from the sorted array in O(n) time (n is the number of elements in the array).
	 * Compare how similar the code is to a binary search algorithm. Both are using the divide and conquer methodology.
	 * Because the input array could be subdivided in at most log(n) times, the extra stack space used by the recursion is in O(log n).
	 */
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}
	
	private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
		if (start > end)	return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);
		return node;
	}
	/*
	 * Further Thoughts:
	 * Consider changing the problem statement to “Converting a singly linked list to a balanced BST”.
	 * How would your implementation change from the above? See Question [30. Convert Sorted List to Balanced Binary Search Tree].
	 */
}

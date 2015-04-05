package Chapter4_BinaryTree;

import leetcode.datastructure.TreeNode;

/**
 * 25. Validate Binary Search Tree
 * Code it now: https://oj.leetcode.com/problems/validate-binary-search-tree/
 * 
 * Question:
 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
 *
 *Solution:
 *First, you must understand the difference between Binary Tree and BST.
 *Binary tree is a tree data structure in which each node has at most two child nodes.
 *A BST is based on binary tree, but with the following additional properties:
 *	- The left subtree of a node contains only nodes with keys less than the node’s key.
 *	- The right subtree of a node contains only nodes with keys greater than the node’s key.
 *	- Both the left and right subtrees must also be binary search trees.
 *People who do not understand the definition of BST may give the following algorithm:
 *Assume that the current node’s value is k. Then for each node, check if the left node’s value is less than k and the right node’s value is greater than k.
 *If all of the nodes satisfy this property, then it is a BST.
 *It sounds correct and convincing, but look at this counter example below: A sample tree that we name it as binary tree (1).
 *10 （5，15）， 15（6，20）
 *It’s obvious that this is not a valid BST, since (6) could never be on the right of (10).
 */
public class Validate_Binary_Search_Tree {

	/**
	 * O(n^2) runtime, O(n) stack space – Brute force:
	 * Based on BST’s definition, we can easily devise a brute force solution:
	 * Assume that the current node’s value is k. Then for each node, 
	 * check if all nodes of left subtree contain values that are less than k. 
	 * Also check if all nodes of right subtree contain values that are greater than k.
	 * If all of the nodes satisfy this property, then it must be a BST.
	 * Below is the brute force code that is inefficient:
	 */
	public boolean isValidBST1(TreeNode root) {
		if (root == null)	return true;
		return isSubtreeLessThan(root.left, root.val)
				&& isSubtreeGreaterThan(root.right, root.val)
				&& isValidBST1(root.left) && isValidBST1(root.right);
	}
	
	private boolean isSubtreeLessThan(TreeNode p, int val) {
		if (p == null)	return true;
		return p.val < val
				&& isSubtreeLessThan(p.left, val)
				&& isSubtreeLessThan(p.right, val);
	}
	
	private boolean isSubtreeGreaterThan(TreeNode p, int val) {
		if (p == null)	return true;
		return p.val > val 
				&& isSubtreeGreaterThan(p.left, val)
				&& isSubtreeGreaterThan(p.right, val);
	}
	/*
	 * The worst case runtime complexity is O(n^2) for the brute force algorithm,
	 * when the tree degenerates into a linked list with n nodes.
	 */
	
	/**
	 * O(n) runtime, O(n) stack space – Top-down recursion:
	 * avoid examining all nodes of both subtrees in each pass by passing down the low and high limits from the parent to its children.
	 * Refer back to the binary tree (1) above. 
	 * As we traverse down the tree from node (10) to right node (15), we know for sure that the right node’s value fall between 10 and + .
	 * Then, as we traverse further down from node (15) to left node (6), we know for sure that the left node’s value fall between 10 and 15.
	 * And since (6) does not satisfy the above requirement, we can quickly determine it is not a valid BST.
	 */
	public boolean isValidBST2(TreeNode root) {
		return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean valid(TreeNode p, int low, int high) {
		if (p == null)	return true;
		return p.val > low && p.val < high
				&& valid(p.left, low, p.val)
				&& valid(p.right, p.val, high);
	}
	/*
	 * This algorithm runs in O(n) time, where n is the number of nodes of the binary tree.
	 */
	
	/**
	 * Sharp readers may notice that the above code does not work if the tree contains the smallest or the largest integer value. How could we fix this?
	 * One way to fix this is to use null to represent the infinity.
	 */
	public boolean isValidBST3(TreeNode root) {
		return valid3(root, null, null);
	}
	
	private boolean valid3(TreeNode p, Integer low, Integer high) {
		if (p == null)	return true;
		return (low == null || p.val > low) && (high == null || p.val < high)
				&& valid3(p.left, low, p.val)
				&& valid3(p.right, p.val, high);
	}
	
	/**
	 * O(n) runtime, O(n) stack space – In-order traversal:
	 * Another solution is to do an in-order traversal of the binary tree, and verify that its in-order elements follow a strict monotonic increasing order.
	 * During the in-order traversal, we verify that the previous value is less than the current node’s value.
	 * The runtime complexity is also O(n).
	 */
	private TreeNode prev;
	public boolean isValidBST4(TreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}
	
	private boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null)	return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.val <= prev.val)	return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}
}
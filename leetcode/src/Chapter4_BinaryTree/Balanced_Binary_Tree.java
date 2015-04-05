package Chapter4_BinaryTree;

import leetcode.datastructure.TreeNode;

/**
 * 28. Balanced Binary Tree
 * Code it now: https://oj.leetcode.com/problems/balanced-binary-tree/
 * 
 * Question:
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than 1.
 *
 */
public class Balanced_Binary_Tree {

	/**
	 * O(n^2) runtime, O(n) stack space – Brute force top-down recursion:
	 * We could devise a brute force algorithm directly based on the above definition. We also reused the [Recursion] approach to find the maximum depth of a subtree.
	 * The brute force algorithm worst case runtime complexity is O(n^2) when the input tree is degenerated.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)	return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
				&& isBalanced(root.left)
				&& isBalanced(root.right);
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null)	return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	/**
	 * O(n) runtime, O(n) stack space – Bottom-up recursion:
	 * It seems that the above approach is recalculating max depth repeatedly for each node. We could avoid the recalculation by passing the depth bottom-up.
	 * We use a sentinel value –1 to represent that the tree is unbalanced so we could avoid unnecessary calculations.
	 * In each step, we look at the left subtree’s depth (L), and ask: “Is the left subtree unbalanced?” If it is indeed unbalanced, we return –1 right away.
	 * Otherwise, L represents the left subtree’s depth. We then repeat the same process for the right subtree’s depth (R).
	 * We calculate the absolute difference between L and R.
	 * If the subtrees’ depth difference is less than one, we could return the height of the current node, otherwise return –1 meaning the current tree is unbalanced.
	 */
	public boolean isBalanced2(TreeNode root) {
		return maxDepth(root) != -1;
	}
	
	private int maxDepth2(TreeNode root) {
		if (root == null)	return 0;
		int L = maxDepth2(root.left);
		if (L == -1)	return -1;
		int R = maxDepth2(root.right);
		if (R == -1)	return -1;
		return (Math.abs(L -R) <= 1) ? (Math.max(L, R) + 1) : -1;
	}
}
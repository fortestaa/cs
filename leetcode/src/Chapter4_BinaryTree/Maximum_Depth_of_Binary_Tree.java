package Chapter4_BinaryTree;

import leetcode.datastructure.TreeNode;

/**
 * 26. Maximum Depth of Binary Tree
 * Code it now: https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Question:
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class Maximum_Depth_of_Binary_Tree {

	/**
	 * Solution:
	 * The maximum height of a binary tree is defined as the number of nodes along the path from the root node to the deepest leaf node.
	 * Note that the maximum depth of an empty tree is 0.
	 */
	
	/**
	 * O(n) runtime, O(log n) space – Recursion:
	 * We could solve this easily using recursion, because each of the left child and right child of a node is a sub-tree itself.
	 * We first compute the max height of left sub-tree, and then compute the max height of right sub-tree. The maximum depth of the current node is the greater of the two maximums plus one.
	 * For the base case, we look at a tree that is empty, which we return 0.
	 * Assume that n is the total number of nodes in the tree. The runtime complexity is O(n) because it traverse each node exactly once.
	 * As the maximum depth of a binary tree is O(log n), the extra space cost is O(log n) due to the extra stack space used by the recursion.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)	return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
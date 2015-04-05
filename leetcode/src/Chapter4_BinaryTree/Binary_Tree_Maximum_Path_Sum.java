package Chapter4_BinaryTree;

import leetcode.datastructure.TreeNode;

/**
 * 31. Binary Tree Maximum Path Sum
 * Code it now: https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Question:
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 * For example, given the below binary tree,
 *    1 
 *   /\ 
 *  2  4
 * /\ 
 * 2 3
 * The highlighted path yields the maximum sum 10 （4+1+2+3.
 * 
 * Example Questions Candidate Might Ask:
 * Q: What if the tree is empty?
 * A: Assume the tree is non-empty.
 * Q: How about a tree that contains only a single node?
 * A: Then the maximum path sum starts and ends at the same node.
 * ￼￼Q: What if every node contains negative value?
 * A: Then you should return the single node value that is the least negative.
 * Q: Does the maximum path have to go through the root node?
 * A: Not necessarily. For example, the below tree yield 6 （2+4） as the maximum path sum and does not go through root.
 *   -5
 *   /\
 *  2  3
 *  /\
 * -1 4
 * 
 * Hint:
 * Anytime when you found that doing top down approach uses a lot of repeated calculation, bottom up approach usually is able to be more efficient.
 *
 */
public class Binary_Tree_Maximum_Path_Sum {

	/**
	 *        _____Node____ 
	 *       /             \ 
	 *      /               \
	 *  left subtree   right subtree
	 *  Try the bottom up approach. At each node, the potential maximum path could be one of these cases:
	 *  i. max(left subtree) + node
	 *  ii. max(right subtree) + node
	 *  iii. max(left subtree) + max(right subtree) + node
	 *  iv. the node itself
	 *  Then, we need to return the maximum path sum that goes through this node and to either one of its left or right subtree to its parent.
	 *  There’s a little trick here:
	 *  If this maximum happens to be negative, we should return 0, which means: “Do not include this subtree as part of the maximum path of the parent node”,
	 *  which greatly simplifies our code.
	 */
	private int maxSum;
	
	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMax(root);
		return maxSum;
	}
	
	private int findMax(TreeNode p) {
		if (p == null)	return 0;
		int left = findMax(p.left);
		int right = findMax(p.right);
		maxSum = Math.max(p.val + left +right, maxSum);
		int ret = p.val + Math.max(left, right);
		return ret > 0 ? ret : 0;
	}
}
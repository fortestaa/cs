package Chapter4_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.datastructure.TreeNode;

/**
 * 27. Minimum Depth of Binary Tree
 * Code it now: https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Question:
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Similar to Question [26. Maximum Depth of Binary Tree], here we need to find the minimum depth instead.
 *
 */
public class Minimum_Depth_of_Binary_Tree {

	/**
	 * O(n) runtime, O(log n) space – Depth-first traversal:
	 * Similar to the [Recursion] approach to find the maximum depth, but make sure you consider these cases:
	 * 	i. The node itself is a leaf node. The minimum depth is one.
	 * 	ii. Node that has one empty sub-tree while the other one is non-empty. Return the minimum depth of that non-empty sub-tree.
	 */
	public int minDepth(TreeNode root) {
		if (root == null)	return 0;
		if (root.left == null)	return minDepth(root.right) + 1;
		if (root.right == null)	return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
	
	/**
	 * O(n) runtime, O(n) space – Breadth-first traversal:
	 * Note that the previous approach traverses all the nodes even for a highly unbalanced tree.
	 * In fact, we could optimize this scenario by doing a breadth-first traversal (also known as level-order traversal).
	 * When we encounter the first leaf node, we immediately stop the traversal.
	 * We also keep track of the current depth and increment it when we reach the end of level.
	 * We know that we have reached the end of level when the current node is the right-most node.
	 * Compared to the recursion approach, the breadth-first traversal works well for highly unbalanced tree because it does not need to traverse all nodes.
	 * The worst case is when the tree is a full binary tree with a total of n nodes. In this case, we have to traverse all nodes.
	 * The worst case space complexity is O(n), due to the extra space needed to store current level nodes in the queue.
	 */
	public int minDepth2(TreeNode root) {
		if (root == null)	return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode rightMost = root;
		int depth = 1;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left == null && node.right == null)	break;
			if (node.left != null)	q.add(node.left);
			if (node.right != null)	q.add(node.right);
			if (node == rightMost) {
				depth++;
				rightMost = (node.right != null) ? node.right : node.left;
			}
		}
		return depth;
	}
}
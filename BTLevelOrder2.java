package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 
 *  3
   / \
  9  20
    /  \
   15   7
 * return its bottom-up level order traversal as: 
 * [ 
 * 	[15,7], 
 * 	[9,20], 
 * 	[3] 
 * ]
 */
public class BTLevelOrder2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		if (root == null)   return rs;
		
		Stack<List<Integer>> s = new Stack<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				tmp.add(n.val);
				if (n.left != null)	q.add(n.left);
				if (n.right != null)	q.add(n.right);
			}
			s.push(tmp);
		}
		while (!s.isEmpty()) {
			rs.add(s.pop());
		}
		return rs;
	}
	
	public static void main(String[] args) {
		BTLevelOrder2 b = new BTLevelOrder2();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		root.left = n1;	root.right = n2;
		n2.left = n3; n2.right = n4;
		List<List<Integer>> rs = b.levelOrderBottom(root);
		System.out.println('[');
		for (int i = 0; i < rs.size(); i++) {
			System.out.println(rs.get(i));
		}
		System.out.println(']');
	}
}

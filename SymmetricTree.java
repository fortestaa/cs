package easy;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
	// mine, recursive
	public boolean isSymmetric0(TreeNode root) {
		if (root == null)	return true;
		return isSymmetric(root.left, root.right);
	}
	
	private boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null || r == null) {
			return (l == null && r == null);
		}
		return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
	}
	
	// iterative
	public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root.left);
        s.push(root.right);
        while (!s.isEmpty()) {
            TreeNode n1 = s.pop();
            TreeNode n2 = s.pop();
            if (n1 == null && n2 == null)   continue;
            if (n1 == null || n2 == null || n1.val != n2.val)   return false;
            s.push(n1.left);	// add those pairs that should be symmetric
            s.push(n2.right);
            s.push(n1.right);
            s.push(n2.left);
        }
        return true;
    }
	// https://github.com/FreeTymeKiyan/LeetCode-Sol-Res/blob/master/Easy/SymmetricTree.java
}

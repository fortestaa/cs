package easy;

/**
 * Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
        		&& isBalanced(root.left)
        		&& isBalanced(root.right);
    }
    
    private int maxDepth(TreeNode p) {
        if (p == null)  return 0;
        return Math.max(maxDepth(p.left), maxDepth(p.right)) + 1;
    }
    
	// mine
	public boolean isBalanced0(TreeNode root) {
		if (root == null)	return true;
		return helper(root.left, root.right);
	}
	
	private boolean helper(TreeNode l, TreeNode r) {
		if (Math.abs(depth(l) - depth(r)) > 1)	return false;
		return isBalanced0(l) && isBalanced0(r);
	}
	
	private int depth(TreeNode n) {
		if (n == null)	return 0;
		if (n.left == null && n.right == null)	return 1;
		return 1 + Math.max(depth(n.left), depth(n.right));
	}
}

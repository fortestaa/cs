package easy;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)	return p == q; // if one of them is null, it will return false. both null, true.
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // equal val, equal subtrees
	}
	
	// mine
	public boolean isSameTree0(TreeNode p, TreeNode q) {
		if (p == null && q == null)	{
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		
		if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}

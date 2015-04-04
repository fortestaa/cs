package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Tree Level Order Traversal 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *  3
   / \
  9  20
    /  \
   15   7
 * return its level order traversal as:
 * [
  		[3],
  		[9,20],
  		[15,7]
   ]
 */
public class BTLevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)   return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                currLevel.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null)    queue.add(n.right);
            }
            result.add(currLevel);
        }
        return result;
    }

	// mine
	public List<List<Integer>> levelOrder0(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)   return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int levelcnt = 1;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int currcount = levelcnt;
            levelcnt = 0;
            for (int i = 0; i < currcount; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                    levelcnt++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    levelcnt++;
                }
            }
            result.add(tmp);
        }
        return result;
	}
	
	public static void main(String[] args) {
		BTLevelOrder b = new BTLevelOrder();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		root.left = n1;	root.right = n2;
		n2.left = n3; n2.right = n4;
		List<List<Integer>> rs = b.levelOrder(root);
		System.out.println('[');
		for (int i = 0; i < rs.size(); i++) {
			System.out.println(rs.get(i));
		}
		System.out.println(']');
	}
}

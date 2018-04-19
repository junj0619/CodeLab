/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {                
        if (root == null || root.left == null) return root;
        
        TreeNode newHead = upsideDownBinaryTree(root.left);
        
        TreeNode cur = root;
        cur.left.left = cur.right;
        cur.left.right = cur;
        cur.left = null;
        cur.right = null;
        
        return newHead;
    }        
}

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
    //Bottom-Up
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;        
    }
    
    
    //Follow up 1: Find LCA of K'Nodes
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        if (root == null)
            return root;
        
        for (TreeNode node : nodes) {
            if (node == root) return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);
        
        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;        
    }
    
}

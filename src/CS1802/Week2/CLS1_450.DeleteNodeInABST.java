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
    public TreeNode deleteNode(TreeNode root, int key) {       
        if (root == null) return null; //*** Base condition
        
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) 
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode pred = findPred(root.left);
                root.val = pred.val;
                root.left = deleteNode(root.left, pred.val);    //update left sub-tree
            }
        }
        return root;
    }
    
    private TreeNode findPred(TreeNode root) {        
        while (root.right != null) 
            root = root.right;
        return root;
    }
}

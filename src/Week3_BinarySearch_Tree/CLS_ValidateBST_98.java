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
    //By Top-Down
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        
        if (root.val <= min || root.val >= max)
            return false;
        
        return helper(root.left, min, root.val)
            && helper(root.right, root.val, max);
    }
    
}

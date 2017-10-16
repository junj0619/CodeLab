/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
 
 
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;      
        return getSum(root, 0);        
    }
    
    public int getSum(TreeNode root, int val) {
        if (root == null) return 0;       
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) return val;            
                             
        return  getSum(root.left, val) + getSum(root.right, val);    
    }
}

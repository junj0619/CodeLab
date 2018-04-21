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
//Approach #1: DFS(TOP-DOWN) search each node and all the sub-trees are doing same 
//Time Complexity: O(n^2) = n + (n-1) + (n-2) + (n-3) + (n-4) + .......+ 1
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
    
//Approach #2: DFS(BOTTOM-UP) worest case access entrie tree once. if find unBalance return -1 immediately no need to check anymore
//Time Complexity: O(n)     
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = getDepth(root.left);
        if (left == -1) return -1;
        
        int right = getDepth(root.right);
        if (right == -1) return -1;
        
        if (Math.abs(left - right) > 1) return -1;
        
        return 1 + Math.max(left, right);
    }
}

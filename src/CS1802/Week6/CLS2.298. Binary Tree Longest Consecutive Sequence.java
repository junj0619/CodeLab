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
    private int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root, 0, 0);
        
        return max;
    }
    
    private void dfs (TreeNode root, int sum, int pre) {
        if (root == null) return;
        
        if (root.val - 1 == pre) {
            sum++;
        } else {
            sum = 1;
        }
        
        max = Math.max(sum, max);
        
        dfs(root.left, sum, root.val);
        dfs(root.right, sum, root.val);        
    }
}

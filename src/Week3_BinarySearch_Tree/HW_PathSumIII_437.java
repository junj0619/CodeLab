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
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return getPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);                
    }
    
    public int getPathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        
        int count = 0;
        if(root.val == sum) count++;
        count += getPathSum(root.left, sum - root.val);
        count += getPathSum(root.right, sum - root.val);
        return count;        
    }
}

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
 *            1
 *          /   \
 *         2     4
 *        / \   / \
 *      -5  -3 9  3
 *
 *       Max: 2 + 1 + 4 + 9 = 16
 *
 *
 *         -10
 *       /     \
 *      2      4
 *     / \    /  \
 *    7  -5  11  2
 *
 *    Max: 4 + 11 + 2 = 17
 *
 *        -9
 *     /      \
 *    10       3
 *   /   \    /  \
 *  -20 -10 -5   -1
 *
 *   Max: 10
 *
 *      2
 *     /
 *   -1
 *   Max: 2
 */
class Solution {
    class ResultType {
        int singlePath;
        int globalPath;
        ResultType (int singlePath, int globalPath) {
            this.singlePath = singlePath;
            this.globalPath = globalPath;
        }
    }
    
    public int maxPathSum(TreeNode root) {        
        if(root == null) return 0;
        return getMax(root).globalPath;
    }
    
    public ResultType getMax(TreeNode root) {
        if (root == null)
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
                
        ResultType left = getMax(root.left);
        ResultType right = getMax(root.right);
        
        // Get wrong anwser for   2
        //                      -1
        // MIN_VALUE + (-1) = 2147483647 casuing result become -1;
        // int singlePath = Math.max(root.val, root.val + Math.max(left.singlePath, right.singlePath));
        
        int singlePath = root.val + Math.max(0, Math.max(left.singlePath, right.singlePath));
        int globalPath = Math.max(Math.max(left.globalPath, right.globalPath)
                                  , root.val + Math.max(0, left.singlePath) + Math.max(0, right.singlePath));
        return new ResultType(singlePath, globalPath);
    }
}

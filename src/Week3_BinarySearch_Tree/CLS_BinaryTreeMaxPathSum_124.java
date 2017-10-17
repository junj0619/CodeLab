/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *            1
 *          /   \
 *         2     4
 *        / \   / \
 *      -5  -3 9   3
 *
 *       Max: 2 + 1 + 4 + 9 = 16
 *
 *
 *         -10
 *       /     \
 *      2      4
 *     / \    /  \
 *    7  -5  11   2
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
 *        2
 *      /
 *    -1
 *
 *   Max: 2
 */
class Solution {
    class Path {        
        int singlePath;
        int globlePath;
        Path (int singlePath, int globlePath) {
            this.singlePath = singlePath;
            this.globlePath = globlePath;
        }
    }
    
    public int maxPathSum(TreeNode root) {        
        if (root == null) return 0;   
        if (root.left == null && root.right == null) return root.val;
        
        return getMaxPath(root).globlePath;
    }
    
    public Path getMaxPath(TreeNode root) {        
        if (root == null) return new Path(Integer.MIN_VALUE, Integer.MIN_VALUE);
        
        Path left = getMaxPath(root.left);
        Path right = getMaxPath(root.right);
        int singlePath = root.val + Math.max(0, Math.max(left.singlePath, right.singlePath));
        int globlePath = Math.max(Math.max(left.globlePath, right.globlePath), (root.val + Math.max(left.singlePath, 0) +                                                                                                    Math.max(right.singlePath, 0)));
        return new Path(singlePath, globlePath);
    }
}

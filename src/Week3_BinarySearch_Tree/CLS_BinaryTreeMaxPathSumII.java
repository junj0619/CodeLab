 * Binary Tree Max Path Sum II
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree and contain at least one node in it.
 *
 *
 *           3
 *         /    \
 *        4      6
 *       / \    /  \
 *      -1 10  2    20
 *
 *      Result : 3 -> 6 -> 20 = 29

public class BinaryTreeMaxPathSumII {
    public int getMaxSum(TreeNode root) {
            if (root == null) return 0;

            int left = getMaxSum2(root.left);
            int right = getMaxSum2(root.right);

            return root.val + Math.max(0, Math.max(left, right));
        }
}    

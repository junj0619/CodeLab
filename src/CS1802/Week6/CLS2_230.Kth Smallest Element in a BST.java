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
    public int kthSmallest(TreeNode root, int k) {
        int i = 1;
        Deque<TreeNode> q = new ArrayDeque<>();
        
        while (root != null || !q.isEmpty()) {
            while (root != null) {
                q.push(root);
                root = root.left;
            }
            
            TreeNode cur = q.pop();
            
            if (i++ == k) {
                return cur.val;
            }
            
            if (cur.right != null) {
                root = cur.right;
            }
        }
        return 0;
    }
}

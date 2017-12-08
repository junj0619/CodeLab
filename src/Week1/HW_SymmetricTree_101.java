/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //By DFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return helper(root.left, root.right);        
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        
        if (left == null || right == null || left.val != right.val) return false;
        
        return helper(left.right, right.left) && helper(left.left, right.right);
    }
}

//By BFS level traversal
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                
                if (left == null && right == null)
                    continue;
                if (left == null || right == null || left.val != right.val)
                    return false;                                                
                
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);                
            }            
        }
        return true;
    }
}

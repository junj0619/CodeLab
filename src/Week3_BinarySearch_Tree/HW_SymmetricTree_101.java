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
 *         1
 *       /   \
 *      2     2
 *     / \   / \
 *    3  4  4  3
 * Result: TRUE
 *
 *         1
 *       /   \
 *      2     2
 *     /     /
 *    3     3
 * Result: FALSE
 *
 *         1
 *       /   \
 *      2     2
 *      \    /
 *      3   3
 * Result: TRUE
 *
 *        1
 *      /   \
 *     3     2
 * Result: FALSE
 *
 *        1
 *      /   \
 *     2     2
 *    /
 *   3
 * Result: FALSE
 */
class Solution {
    //By level traversal and compare. Not need to traversal all the tree node in the best scenario
    //Use Queue to compare left tree left vs right tree right && left tree right vs right tree left
    public boolean isSymmetric(TreeNode root) {  
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
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
        return true;                
    }
}

//By Recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) 
            return true;
        
        if (left == null || right == null || left.val != right.val)
            return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

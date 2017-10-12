/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//By Recursion
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {        
        if (p == null && q == null)
            return true;
        
        if (p == null || q == null || p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);        
    }
}

//By BFS Level Traversal
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(p);
        queue.offer(q);
        
        while(!queue.isEmpty()) {
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();
            
            if (nodeP == null && nodeQ == null)
                continue;
            
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val)
                return false;
            
            queue.offer(nodeP.left);
            queue.offer(nodeQ.left);
            queue.offer(nodeP.right);
            queue.offer(nodeQ.right);
        }
        return true;
    }
}

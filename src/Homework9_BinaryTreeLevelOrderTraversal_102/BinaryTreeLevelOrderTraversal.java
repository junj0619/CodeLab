/***
*    3
*   / \
*  9  20
*    /  \
*   15   7
*
*
*  [
*   [3],
*   [9,20],
*   [15,7]
*  ]
*
*  Time Complexity: O(n) 2n each node enQueue and dequeue once
*  Space Complexity: O(2n) queue size = leafs n:height
***/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        
        if (root == null) return list;
        queue.offer(root);
        
        while(!queue.isEmpty()) {            
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList();
                        
            for (int i = 0; i < levelSize; i++) {                                
                TreeNode node = queue.poll(); 
                temp.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(temp);            
        }
        
        return list;
    }
}

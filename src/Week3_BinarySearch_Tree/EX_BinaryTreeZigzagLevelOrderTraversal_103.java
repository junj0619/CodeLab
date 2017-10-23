/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 */
 //By BFS Level Traversal
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
                
        List<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isReverse = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            isReverse = !isReverse;
                
            for (int i = 0; i < size; i++) {                           
                root = queue.poll();
                if (isReverse) 
                    list.add(0, root.val);  //KeyPoint: insert element at the 0 index.
                else
                    list.add(root.val);
                
                if (root.left != null)
                    queue.offer(root.left);
                
                if (root.right != null)
                    queue.offer(root.right);
            }                                    
            resList.add(list);
        }
        
        return resList;
    }
}

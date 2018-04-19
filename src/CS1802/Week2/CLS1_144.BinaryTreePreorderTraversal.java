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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> right = new ArrayDeque<>();
        
        while (root != null) {
            list.add(root.val);
            
            if (root.right != null)
                right.push(root.right);
            
            root = root.left;
            
            if (root == null && !right.isEmpty())
                root = right.pop();
        }
        return list;
    }
}

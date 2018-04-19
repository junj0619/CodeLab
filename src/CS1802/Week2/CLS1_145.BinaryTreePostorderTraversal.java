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
    class Pair {
        TreeNode node;
        int checked;
        Pair (TreeNode node, int checked) {
            this.node = node;
            this.checked = checked;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));
        
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            if (cur.node == null) 
                continue;
            else if (cur.checked == 1) 
                list.add(cur.node.val);
            else {
                stack.push(new Pair(cur.node, 1));
                stack.push(new Pair(cur.node.right, 0));
                stack.push(new Pair(cur.node.left, 0));
            }            
        }
        return list;
    }
}

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();        
        StringBuilder sb = new StringBuilder();
        if (root == null) return res;
        
        getPath(root, sb, res);
        return res;
    }
    
    public void getPath(TreeNode root, StringBuilder sb, List<String> res) {        
        if (root == null) {
            sb.delete(sb.length() - 2, sb.length());
            return;
        }
        
        sb.append(root.val);
        getPath(root.left, sb.append("->"), res);
        getPath(root.right, sb.append("->"), res);    
        
        if (root.left == null && root.right == null)
            res.add(sb.toString());
        
        int len = sb.length();
        if (len > 1 && (String.valueOf(root.val).length() + 2) < len)            
            sb.delete(len - (String.valueOf(root.val).length() + 2), len);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *  All root-to-leaf paths are:
 *
 *  ["1->2->5", "1->3"]
 *
 */
class Solution {    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resPath = new ArrayList<>();
        if (root == null) return resPath;
                   
        addTreePath(root, "", resPath);
        return resPath;
    }
    
    public void addTreePath(TreeNode root, String curPath, List<String> resPath) {
        if (root.left == null && root.right == null) {            
            String val = curPath + root.val;
            resPath.add(val);            
        }
        
        curPath += root.val + "->";
        if (root.left != null)
            addTreePath(root.left, curPath, resPath);
        if (root.right != null)
            addTreePath(root.right, curPath, resPath);
    }
    
    //Approach 2: By StringBuilder
    private void helper(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) 
            return;
        
        sb.append(root.val + "->");
        if (root.left == null && root.right == null) {
            sb.delete(sb.length() - 2, sb.length());
            res.add(sb.toString());
            sb.delete(sb.length() - String.valueOf(root.val).length(), sb.length());
            return;
        }
        helper(root.left, sb, res);
        helper(root.right, sb, res);
        sb.delete(sb.length() - String.valueOf(root.val).length() - 2, sb.length());
    }
}

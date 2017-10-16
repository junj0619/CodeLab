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
}

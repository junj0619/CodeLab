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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        int len =  inorder.length - 1;
        return helper(inorder, postorder, 0, len, 0, len);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        
        int val = postorder[postEnd];
        int pos = 0;
        
        TreeNode root = new TreeNode(val);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {                
                pos = i; 
                break;                
            }
        }
        
        int leftSize = pos - inStart;
        
        root.left = helper(inorder, postorder, inStart, pos - 1, postStart, postStart + leftSize - 1);
        root.right = helper(inorder, postorder, pos + 1, inEnd, postStart + leftSize, postEnd - 1);
        
        return root;
    }
}

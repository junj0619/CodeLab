/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 *
 *       1
 *     /   \
 *    3     4
 *   / \   / \
 *  5   6 7   8
 *
 *  In-Order  :[5, 3, 6, 1, 7, 4, 8]
 *  Post-Order:[5, 6, 3, 7, 8, 4, 1]
 *
 *  Idea: Get root from post order. [1]
 *        Then search root [1] in inorder arr
 *        All left tree nodes are in the left of [1] node
 *        Get left length. Divide tree to left and right in both inorder and postorder arr
 *        Repeat same logic and return treenode root to previous recursion stack
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

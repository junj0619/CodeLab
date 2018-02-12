/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * to
 *   4
 *  / \
 * 5   2
 *    / \
 *   3   1  
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //Time Complexity: O(n)
        //Space Complexity: O(n/2) = O(n)  because input tree only have two branchs and we only need do level of tree recursion stacks
        if (root == null || root.left == null) 
            return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;                
    }
}

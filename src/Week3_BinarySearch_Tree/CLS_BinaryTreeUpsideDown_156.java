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
 */

class Solution {
    //Approach 1:
    //Time Complexity: O(n)
    //Space Complexity: O(n/2) = O(n)  because input tree only have two branchs and we only need do level of tree recursion stacks
    public TreeNode upsideDownBinaryTree(TreeNode root) {        
        if (root == null || root.left == null) 
            return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;                
    }
    //Approach 2:
    //Time Complexity: O(n), Space Compleixty: O(1) only use 3 pointers
     public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode sib = null, par = null, next = null;                           
        
        while (root != null) {
            next = root.left;
            
            root.left = sib;
            sib = root.right;
            root.right = par;            
           
            par = root;
            root = next;            
        }
        return par;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    //Recursive Bottom-Top
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        //Assume all lower levels are processed
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        //Process current level
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

 //Time Complexity : O(n)
 //Space Complexity : O(n)   
 //Use Stack save all left most node. Then do the Rotate process from Bottom-Top  
     public TreeNode upsideDownBinaryTreeByStack(TreeNode root) {
        if (root == null) return null;
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        TreeNode newRoot = stack.peek();
        
        while (!stack.isEmpty()) {
            TreeNode nodeP = stack.pop(); //Parent Node
            
            if(!stack.isEmpty()) {
                TreeNode nodeC = stack.peek(); //Child Node
                nodeP.left = nodeC.right;
                nodeP.right = nodeC;                
                nodeC.left = null;
                nodeC.right = null;
            }                                                
        }
        return newRoot;
    }
}

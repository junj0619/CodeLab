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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
    }
    
    private TreeNode helper(int posStart, int posEnd, int inStart, int inEnd, int[] inorder, int[] postorder, HashMap<Integer, Integer> map) {
        if (posStart > posEnd || inStart > inEnd) 
            return null;
        
        int index = map.get(postorder[posEnd]);        
     
        //[1,2,3,4]
        //[2,3,1,4]
        TreeNode root = new TreeNode(postorder[posEnd]);
        int leftLen = index - inStart;
        root.left = helper(posStart, posStart + leftLen - 1, inStart, index - 1, inorder, postorder, map);
        root.right = helper(posStart + leftLen, posEnd - 1, index + 1, inEnd, inorder, postorder, map);
        return root;        
    }
}

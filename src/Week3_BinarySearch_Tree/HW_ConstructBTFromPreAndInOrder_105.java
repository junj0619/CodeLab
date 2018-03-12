/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 *       1
 *     /   \
 *    3     4
 *   / \   / \
 *  5  6  7   8
 *
 *
 *  Pre-Order :[1, 3, 5, 6, 4, 7, 8]
 *  In-Order  :[5, 3, 6, 1, 7, 4, 8] 
 *  
 *  Simliar idea like build Tree from inorder and postorder.
 *  Only difference is the root that is in the [Start] position of preorder array
 */
class Solution {
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(0, 0, inorder.length, preorder, inorder, map);        
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd) 
            return null;
        
        TreeNode node = new TreeNode(preorder[preStart]);        
        int inOrderIDX = map.get(preorder[preStart]);
        
        node.left = helper(preStart + 1, inStart, inOrderIDX - 1, preorder, inorder, map);
        node.right = helper(preStart + inOrderIDX - inStart + 1, inOrderIDX + 1, inEnd, preorder, inorder, map);
        return node;
    }
}

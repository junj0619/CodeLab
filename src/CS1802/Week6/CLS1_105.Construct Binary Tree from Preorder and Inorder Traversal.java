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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>(); //Key : number, Value : index
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(0, 0, len - 1, preorder, inorder, map);
    }
    
    private TreeNode buildTree(int prestart, int instart, int inend, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (prestart > preorder.length - 1 || instart > inend) return null;
        
        int num = preorder[prestart];
        TreeNode root = new TreeNode(num);
        int inorderIDX = map.get(num);
        int offset = inorderIDX - instart;
        
        root.left = buildTree(prestart + 1, instart, inorderIDX - 1, preorder, inorder, map);
        root.right = buildTree(prestart + 1 + offset, inorderIDX + 1, inend, preorder, inorder, map);         
        
        return root;
    }
    
    
}

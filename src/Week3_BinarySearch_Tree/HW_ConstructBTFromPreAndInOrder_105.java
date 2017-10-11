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
        if (preorder == null || inorder == null) return null;

        int len = preorder.length - 1;
        return helper(preorder, inorder, 0, len, 0, len);        
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        int val = preorder[preStart];
        int pos = 0;

        TreeNode root = new TreeNode(val);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                pos = i;
                break;
            }
        }

        int leftSize = pos - inStart;

        root.left = helper(preorder, inorder, preStart + 1, preStart + leftSize, inStart, pos - 1);
        root.right = helper(preorder, inorder, preStart + leftSize + 1, preEnd, pos + 1, inEnd);

        return root;
    }
}

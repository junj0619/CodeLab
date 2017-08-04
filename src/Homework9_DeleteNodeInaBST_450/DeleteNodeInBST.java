/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {        
        TreeNode node = delete(root, key);
        return node;
    }
    
    public TreeNode delete(TreeNode root, int key) {
        if(root == null) return null;
        
        if (root.val > key) {
          root.left = delete(root.left, key);
        } else if(root.val < key) {
          root.right = delete(root.right, key);
        } else {                                                                          
           if (root.left == null && root.right == null) { //delete leaf node     //       12
               return null;                                                      //      /   \
           } else if (root.left == null)  { //delete node has one child          //     4     20  <- successor
               return root.right;                                                //    /  \
           } else if (root.right == null) {                                      //   1    5 <- predecessor 
               return root.left;
           }
            
           //delete node has two children
           //step 1: find predecessor of current node
           //step 2: assign predecessor value to current node
           //step 3: delete the predecessor from current node.left
           TreeNode predecessorNode = findPredecessor(root.left);
           root.val = predecessorNode.val;
           root.left = delete(root.left, predecessorNode.val); 
        } 
        
        return root;
    }
    
    public TreeNode findPredecessor(TreeNode node) {
        if (node.right == null) return node;
        return findPredecessor(node.right);
    }
    
    
}

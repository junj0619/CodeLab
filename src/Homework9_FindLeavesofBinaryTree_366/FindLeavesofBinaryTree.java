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
 *     1
 *    / \    
 *   2   3    => [2,3], false [1]
 *
 *    1
 *   /  \
 *  2    3
 *      /  \     
 *     4    5  => [2,4,5] false [3] false [1]
public class Solution {
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<>();
        
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            if (isLeaf(root, leaves)) root = null;
            leavesList.add(leaves);
        }
        
        return leavesList;
    }
    
    public boolean isLeaf(TreeNode node, List<Integer> leaves){        
        if (node.left == null && node.right == null) {
            leaves.add(node.val);        
            return true;
        }
        
        if (node.left != null) { 
            if (isLeaf(node.left, leaves)) {
                node.left = null;   
            }
        }
        
        if (node.right != null) {
            if (isLeaf(node.right, leaves)) {
                node.right = null;
            }
        }        
         
        return false;    
    }
}

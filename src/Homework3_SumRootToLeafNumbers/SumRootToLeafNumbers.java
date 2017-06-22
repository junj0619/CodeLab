/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        
        return sumHelper(root,0);
    }
    
    public int sumHelper(TreeNode node, int value){
        if(node == null) return 0; 
        value = value * 10 + node.val;
        int sum = 0;
        
        sum += sumHelper(node.left, value);
        sum += sumHelper(node.right, value);
        
        return  sum == 0? value : sum;
    }
}

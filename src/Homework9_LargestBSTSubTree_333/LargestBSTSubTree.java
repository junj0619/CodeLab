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
    public class Result {
        Integer size;
        Integer start;
        Integer end;
        
        Result(Integer size, Integer start, Integer end){
            this.size = size;
            this.start = start;
            this.end = end;
        }
    }
    
    int max = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        
        Result res = getLargestBSTSubtree(root);
        return max;
    }        
    
    public Result getLargestBSTSubtree(TreeNode node) {
        //Base condition: 
        //Means reach leaf.next 
        //Use start = max, end = min for later parent node pass line:42 comparision.
        //This is the special handling when find leaf node. 
        if (node == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        Result left = getLargestBSTSubtree(node.left);
        Result right = getLargestBSTSubtree(node.right);
        //If left/right sub tree is invalid. then the tree from current node is invalid.
        if (left.size == -1 || right.size == -1 || node.val <= left.end || node.val >= right.start) {
            return new Result(-1, 0, 0);
        }
        
        int size = left.size + right.size + 1;        
        max = Math.max(max, size);
        //use Math.min/max to get correct start,end val for leaf node.
        return new Result(size, Math.min(left.start, node.val), Math.max(right.end, node.val));
    }
}

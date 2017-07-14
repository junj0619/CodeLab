/**
*
* Check a binary tree is completed or not. 
* A complete binary tree is a binary tree that every level is completed filled except the deepest level. 
* In the deepest level, all nodes must be as left as possible. See more definition.
*
**/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class ResultType {
    public boolean isFullTree;
    public boolean isCompleteTree;
    public int maxDepth;
    
    ResultType(boolean isFull, boolean isComplete, int maxDepth) {
          isFullTree = isFull;
          isCompleteTree = isComplete;
          maxDepth = maxDepth;
    }  
}


public class Solution {
    public boolean ComplelteBinaryTree(TreeNode root) {

    }
}

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
        if(root == null) {
            return true;
        }        
        return DFS(root).isCompleteTree;
    }
    
    public ResultType DFS(TreeNode root) {
        if(root == null) {
            return new ResultType(true, true, 0);
        }
        
        ResultType left = DFS(root.left);
        ResultType right = DFS(root.right);
        
        if(left.maxDepth == right.maxDepth) {
            if(left.isFullTree && right.isFullTree) {
                return new ResultType(true, true, left.maxDepth + 1);
            } else if(left.isFullTree && right.isCompleteTree) {
                return new ResultType(false, true, left.maxDepth + 1);
            } else {
                return new ResultType(false, false, left.maxDepth + 1);
            }            
        }
        
        if(left.maxDepth == right.maxDepth - 1) {
            if(left.isFullTree && right.isFullTree) {
                return new ResultType(false, true, left.maxDepth + 1);
            } else if(left.isCompleteTree && right.isFullTree) {
                return new ResultType(false, true, left.maxDepth + 1);
            } else {
                return new ResultType(false, false, left.maxDepth + 1);
            }
        }
        
        //left.maxDepth - right.maxDepth >= 2
        return new ResultType(false, false, 0);
    }
}

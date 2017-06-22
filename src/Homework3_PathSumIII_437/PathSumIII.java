/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/**
 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
 
 
public class PathSumIII {
    int result = 0;
    
/**
 * Logic: 
 *       1) Check the path goes LEFT,RIGHT from previous node sum (sum - pre.val)    1)  pre       2)  cur     3)  cur
 *       2) Check the path goes to LEFT from current node (sum - cur.val)                 |            /             \
 *       3) Check the path goes to RIGHT from current node (sum - cur.val)               cur          L               R
 *                                                                                      /   \
 *                                                                                     L     R
 *
 */
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return  0;
        findPathHelper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }
    
    public void findPathHelper(TreeNode root, int sum){
        if(root == null) return;
        
        if(root.val == sum) result++;
        
        findPathHelper(root.left, sum - root.val);
        findPathHelper(root.right, sum - root.val);
    }
}

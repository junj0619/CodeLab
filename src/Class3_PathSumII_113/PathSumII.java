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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<List<Integer>>();
       
        List<Integer> curPath = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        getPathSum(root, curPath, res, sum);
        return res;
    }
    
    public void getPathSum(TreeNode root, List<Integer> curPath, List<List<Integer>> res, int sum) {
        if (root == null) return;
        
        curPath.add(root.val);
        getPathSum(root.left, curPath, res, sum - root.val);
        getPathSum(root.right, curPath, res, sum - root.val);
        
        if (root.left == null && root.right == null && sum - root.val == 0) 
            res.add(new ArrayList<>(curPath));
        
        curPath.remove(curPath.size() - 1);
    }
}

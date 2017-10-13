/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 *
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {        
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        getPath(root, sum, curPath, res);
        
        return res;
    }
    
    public void getPath(TreeNode root, int sum, List<Integer> curPath, List<List<Integer>> res) {
        if (root == null) return;
        
        curPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(curPath));           
        }
        
        getPath(root.left, sum - root.val, curPath, res);
        getPath(root.right, sum - root.val, curPath, res);
        curPath.remove(curPath.size() - 1);
    }
}

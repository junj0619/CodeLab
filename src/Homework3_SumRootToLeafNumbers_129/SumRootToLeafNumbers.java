package Homework3_SumRootToLeafNumbers_129;

/**
 * Created by junjin on 6/22/17.
 */

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
     * Input : [1]
     * Output: [1]
     *
     * Input : [1, 2, 3]
     * Output: 12 + 13 = 25
     *
     * Input : [0,1]
     * Output: 1  => 0 * 10 + 1 = 1
     *
     * Input : [1,0]
     * Output: 10 => 1 * 10 + 0 = 10
     *
     * Input : [1, 2, 3, 4, 5, 6, 7, 8, null, 9, null, 0]                          1
     * Output: 1248 + 1259 + 1360 + 137                                          /    \
     *                                                                          2      3
     *                                                                         / \    / \
     *                                                                        4   5  6   7
     *                                                                       /   /  /
     *                                                                      8   9  0
     * Time Complexity : O(n) numbers of nodes
     * Space Complexity: O(n) Recursion Stack
     */
    public class SumRootToLeafNumbers {

        public int sumNumbers(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return root.val;

            return sumHelper(root,0);
        }
        /**
         * 3 things to do for each node
         * 1) Multiplied by 10 (from previous node result), plus current node.val
         * 2) Pass calculated value result into next level (Left,Right)
         * 3) Summarize calculated result from next level(Left, Right), return to previous level.
         */
        public int sumHelper(TreeNode node, int value){
            if(node == null) return 0;

            value = value * 10 + node.val;

            int sum = 0;
            sum += sumHelper(node.left, value);
            sum += sumHelper(node.right, value);

            return  sum == 0? value : sum;
        }
    }




package Homework1_SymmetricTree_101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by junjin on 6/6/17.
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *    3   3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p>
 * Input : []
 * Output: true
 * <p>
 * Input : [1,2,3,3,null,2,null]
 * Output: false
 * <p>
 * Input : [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Input : [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * Input : [1]
 * Output: true
 * <p>
 * Time Complexity : O(N) only do Breath First traversal once
 * Space Complexity: O(1) only create two TreeNodes
 * <p>
 * Accepted Solutions Runtime Distribution
 * Runtime: 2 ms
 * Beats  : 13.97%
 */
public class SymmetricTree {

    public boolean SymmetricTree(TreeNode root) {

        if (root == null) return true;
        if (root != null && root.left == null && root.right == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        queue.offer(leftTree);
        queue.offer(rightTree);

        while (!queue.isEmpty()) {
            leftTree = queue.poll();
            rightTree = queue.poll();

            if (leftTree == null && rightTree == null) continue;
            if (leftTree == null || rightTree == null) return false;
            if (leftTree.val != rightTree.val) return false;

            queue.offer(leftTree.left);
            queue.offer(rightTree.right);
            queue.offer(leftTree.right);
            queue.offer(rightTree.left);
        }
        return true;
    }

    public boolean SymmetricTree_Recursive(TreeNode leftTree, TreeNode rightTree) {

        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;
        if (leftTree.val != rightTree.val) return false;

        return SymmetricTree_Recursive(leftTree.left, rightTree.right)
                && SymmetricTree_Recursive(leftTree.right, rightTree.left);

    }

}



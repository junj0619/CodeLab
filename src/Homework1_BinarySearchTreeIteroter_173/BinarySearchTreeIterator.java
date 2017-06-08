package Homework1_BinarySearchTreeIteroter_173;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by junjin on 6/7/17.
 *
 * Input : []
 * Output: []
 *
 *        5
 *      /   \
 *     3     8
 *    / \   / \
 *   1   4 7   9
 *
 * Input : [5,3,8,1,4,7,9]
 * Output: [1,3,4,5,7,8,9]
 *
 *
 *         5
 *       /  \
 *      3    8
 *       \    \
 *       4     9
 * Input : [5,3,8,null,4,null,9]
 * Output: [3,4,5,8,9]
 *
 *
 *         5
 *       /   \
 *      3     8
 *     /  \    \
 *    2    4    9
 * Input : [5,3,8,2,4,null,9]
 * Output: [2,3,4,5,8,9]
 *
 *
 *  BST
 *          40    ------1
 *        /     \
 *       30     50  ----2
 *      /  \   /  \
 *     20  35 45   60 --3
 *    /   /  \
 *   10  32  36        -4
 *
 * Input :[40,30,50,29,35,45,60,10,null,32,36] ????? BST allow skip node ????
 * Output:[10,20,30,32,35,36,40,45,50,60]
 *
 * Stack Process:
 * [40]
 * [40,30]
 * [40,30,20]
 * [40,30,20,10]
 * [40,30,20]
 * [40,30]
 * [40,35]
 * [40,35,32]
 * [40,35]
 * [40]
 * [40,36]
 * [40]
 * [50]
 * [50,45]
 * [50]
 * [60]
 * []
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 5 ms
 * Beats: 90.52%
 *
 * Time Complexity: hasNext O(1), next O(n)
 * Space Complexity: hasNext O(1), next O(h)
 */
public class BinarySearchTreeIterator {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BinarySearchTreeIterator(TreeNode root) {

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return val;
    }
}


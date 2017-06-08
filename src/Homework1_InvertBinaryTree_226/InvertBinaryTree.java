package Homework1_InvertBinaryTree_226;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by junjin on 6/7/17.
 *
 * Input :[]
 * Output:[]
 *
 *      1                       1
 *    /    \                  /    \
 *   2      3         ==>    3      2
 *  /  \   /  \             /  \   /  \ 
 * 4    5 6    7           7    6 5    4
 * Input :[1,2,3,4,5,6,7]
 * Output:[1,3,2,5,4,7,6]
 *
 *
 *      1                       1
 *    /    \                  /   \
 *   2      3         ==>    3     2
 *  /         \             /       \ 
 * 4           7           7         4 
 * Input :[1,2,3,4,null,null,7]
 * Output:[1,3,2,7,null,null,4]
 *
 *
 *      1                       1
 *    /    \                  /   \
 *   2      3         ==>    3     2
 *    \    /                  \   / 
 *     4  5                    5 4 
 * Input :[1,2,3,null,4,5,null]
 * Output:[1,3,2,null,5,4,null]
 *
 *
 *
 *      1                      1
 *    /   \                  /   \
 *   2     3         ==>    3     2
 *        / \              / \    
 *       4   5            5   4 
 * Input :[1,2,3,null,null,4,5]
 * Output:[1,3,2,5,4,null,null]
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 1 ms
 * Beats: 1.6%
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 */
public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root != null && root.left == null && root.right == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp;
            TreeNode node = queue.poll();

            temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return root;
    }


}

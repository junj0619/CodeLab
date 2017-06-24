package Homework3_SerializeandDeserializeBinaryTree_297;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by junjin on 6/24/17.
 */
public class SerializeandDeserializeBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    StringBuilder sb = new StringBuilder();
    String spliter = ",";
    String nullNode = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //serialize to root first data then we can get root first in deserialize
        //use pre-order traversal to serialize the bt
        buildString(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split data by ',' and dump into queue
        // dequeue and create Tree structure
        String[] strs = data.split(spliter);
        Deque<String> queue = new LinkedList<>();

        for (String str : strs) {
            queue.offer(str);
        }

        return buildTree(queue);
    }

    public void buildString(TreeNode root) {
        if (root == null) {
            sb.append(nullNode).append(spliter);
            return;
        }

        sb.append(root.val).append(spliter);
        buildString(root.left);
        buildString(root.right);
    }

    public TreeNode buildTree(Deque<String> queue) {
        String node = queue.poll();

        if (node.equals(nullNode)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(node));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


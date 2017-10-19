/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 *        1
 *      /   \
 *     2     3
 *          /  \
 *         4    5
 *
 * DFS(Pre-Order) Idea: 
 *       Serialize Binary Tree By Pre-Order Traversal because in this way the root will be the first element in the string.
 *       After Serialize Binary Tree become [1, 2, NULL, NULL, 3, 4, NULL, NULL, 5, NULL, NULL]
 *
 *       Deserialize Tree split input string to string array by spliter = ","
 *       Then import array into queue then construct tree from pre-order data.
 *
 * Will Try Later:
 *       Actually queue can be replaced by int[10] array. And each time do increament array index to simulate queue.poll();
 */        
public class Codec {

    private String _SPLITER = ",";
    private String _NULL = "NULL";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(_NULL).append(_SPLITER);
            return;
        }
        
        sb.append(root.val).append(_SPLITER);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") return null;
        
        String[] strs = data.split(_SPLITER);
        Deque<String> queue = new ArrayDeque<>();
        
        for(String str : strs) {            
            queue.offer(str);                                               
        }        
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Deque<String> queue) {
        TreeNode root = null;
        String curr = queue.poll();
        
        if (curr != null && !curr.equals(_NULL)) {
            root = new TreeNode(Integer.valueOf(curr));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

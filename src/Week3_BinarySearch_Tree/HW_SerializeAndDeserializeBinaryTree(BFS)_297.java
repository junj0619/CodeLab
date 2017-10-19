/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Idea : 
 *    Serialize do the BFS level traversal. Then tree become [1,2,3,NULL,NULL,4,5,NULL,NULL,NULL,NULL]
 *    Deserialize use queue to save input string. use another parent node queue to save current parent nodes.
 *    Then iterative and poll element from queue tree meanwhile assign left,right node to the current parent node. 
 *
 *  Will do :
 *     Actually first queue is duplicated word like string array after convert the input string.
 *     The queue can be replaced by previous string array. And do the increament index to simulate queue.poll()
 */
public class Codec {
    private String _NULL = "NULL";
    private String _SPLITER = ",";
    // [1,2,3,NULL,NULL,4,5,NULL,NULL,NULL,NULL]
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {        
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);        
        while (!queue.isEmpty()) {            
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(_NULL).append(_SPLITER);
                continue;
            } else {
                sb.append(node.val).append(_SPLITER);
                queue.offer(node.left);
                queue.offer(node.right);
            }            
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") return null;
        
        String[] strs = data.split(_SPLITER);
        Queue<String> queue = new LinkedList<>();
        Queue<TreeNode> parentTreeQueue = new LinkedList<>();
        
        for (String str : strs) {            
            queue.offer(str);
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
        parentTreeQueue.offer(root);
                                     
        buildTree(queue, parentTreeQueue);        
        return root;                                     
    }
    
    private void buildTree(Queue<String> queue, Queue<TreeNode> parentTreeQueue) {        
        while (!queue.isEmpty()) {                                            
            TreeNode root = parentTreeQueue.poll();
            String leftVal = queue.poll();
            String rightVal = queue.poll();
            
            if (!leftVal.equals(_NULL)) {
                TreeNode left = new TreeNode(Integer.valueOf(leftVal));
                root.left = left;                 
                parentTreeQueue.offer(left);
            }
                        
            if (!rightVal.equals(_NULL)) {
                TreeNode right = new TreeNode(Integer.valueOf(rightVal));
                root.right = right;                 
                parentTreeQueue.offer(right);
            }            
        }      
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

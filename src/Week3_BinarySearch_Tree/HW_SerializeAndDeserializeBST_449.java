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
 *       5
 *     /   \
 *    4     6
 *   /       \
 *  3         7
 *
 *  [5, 4, 3, 6, 7]
 *
 *  Pre-Order: [5, 4, 3, NULL, NULL, NULL, 6, NULL, 7, NULL, NULL]
 *        BFS: [5, 4, 6, 3, NULL, NULL, 7, NULL, NULL, NULL, NULL]
 *
 *  LC Solution: maintain smallerQueue and largerQueue
 *               poll out first element from queue.
 *               compare it with with rest of elements in queue
 *               put smaller value in smallerQueue
 *               leave larger value in the queue
 *               Do the Top-Down recursion return result node back to previous level
 *               Then in the previous level create left/right relation.
 *
 *  Corner Case: Handing empty queue before compare value
 *               input data is empty string
 */
public class Codec {
    private String _SPLITER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();        
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        
        sb.append(root.val).append(_SPLITER);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") return null;
        
        String[] strs = data.split(_SPLITER);
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (String str : strs) {
            queue.offer(Integer.valueOf(str));
        }
        return buildTree(queue);
    }
        
    //[5, 4, 3, 6, 7]
    //root: 5, smallerQueue: [4, 3], queue: [6, 7]
    //root5.left => root: 4, smallerQueue: [3], queue: []   <------ L
    //root3.left => root: null, smallerQueue:[], queue: []
    //root3.right => return null
    //root5.right => root: 6, smallerQueue:[], queue:[7]    <------ R
    //root6.left => return null
    //root6.right => root: 7, smallerQueue:[], queue:[]
    
    private TreeNode buildTree(Deque<Integer> queue) {
        if (queue.isEmpty()) return null;
        
        int rootVal = queue.poll();
        TreeNode root = new TreeNode(rootVal);
        Deque<Integer> smallQueue = new ArrayDeque<>();
        
        while (!queue.isEmpty() && queue.peek() < rootVal) {
            smallQueue.offer(queue.poll());
        }
        
        root.left = buildTree(smallQueue);
        root.right = buildTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

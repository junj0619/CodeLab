package Homework3_SerializeandDeserializeBST_449;

/**
 * Created by junjin on 6/22/17.
 * This is not optimized solution!!
 */
public class SerializeandDeserializeBST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        String data="";
        TreeNode root;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            //In order to put first serialize position to be root.
            //We have to use pre-order traversal
            if(root == null) return "";
            traversal(root);
            return data;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length() == 0) return null;

            String [] strs  = data.split(",");

            for(String str : strs){
                int num = Integer.parseInt(str);
                insert(num);
            }
            return root;
        }

        public void traversal(TreeNode root){
            if(root == null) return;

            data += root.val+",";
            traversal(root.left);
            traversal(root.right);
        }

        public void insert(int val){
            if(root == null){
                root = new TreeNode(val);
            }else{
                insertData(root, val);
            }
        }

        public void insertData(TreeNode root, int val){

            if(val < root.val){
                if(root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    insertData(root.left, val);
                }
            } else {
                if(root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    insertData(root.right, val);
                }
            }

        }


    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}

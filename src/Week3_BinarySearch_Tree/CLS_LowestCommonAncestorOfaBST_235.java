/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Bottom-Up
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;        
    }
    
    
    //Follow up 1: Find LCA of K'Nodes
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        if (root == null)
            return root;
        
        for (TreeNode node : nodes) {
            if (node == root) return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);
        
        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;        
    }
    
    //Follow up 2: Targets are not guaranteed in the tree
    //Usage: TreeNode LCA = ct[0] == 2 ? lowestCommonAncestor(root, p, q, ct) : null;    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int[] ct) {
        if (root == null) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (root == p || root == q) {
            ct[0]++;
            return root;
        }
                        
        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;    
    }
    
    //Follow Up_3: Parent Pointer in TreeNode
    /*
    * class TreeNodeP {
    *    private int val;
    *
    *    public TreeNodeP(int val) {
    *        this.val = val;
    *    }
    *
    *    public TreeNodeP left;
    *    public TreeNodeP right;
    *    public TreeNodeP parent;
    *  }
    */
    public TreeNodeP getLCAWithParentNode(TreeNodeP p, TreeNodeP q) {
        TreeNodeP LCANode = null;

        int pHeight = getHeight(p);
        int qHeight = getHeight(q);

        if (pHeight > qHeight)
            LCANode = moveUp(p, q, pHeight - qHeight);
        else
            LCANode = moveUp(q, p, qHeight - pHeight);

        return LCANode;
    }

    private int getHeight(TreeNodeP node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.parent;
        }
        return height;
    }

    private TreeNodeP moveUp(TreeNodeP deep, TreeNodeP shallow, int diff) {

        while (diff > 0) {
            deep = deep.parent;
            diff--;
        }

        while (deep != shallow) {
            deep = deep.parent;
            shallow = shallow.parent;
        }
        return deep;
    }
}

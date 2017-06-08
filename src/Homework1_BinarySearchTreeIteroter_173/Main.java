package Homework1_BinarySearchTreeIteroter_173;

/**
 * Created by junjin on 6/7/17.
 */
public class Main {
    public static void main(String[] args) {

        /*
        *  BST
        *          40    ------1
        *        /    \
        *       30     50  ----2
        *      /  \   /  \
        *     20  35 45   60 --3
        *    /   /  \
        *   10  32   36       -4
        *
        * */

        TreeNode root = new TreeNode(40);
        TreeNode left2 = new TreeNode(30);
        TreeNode right2 = new TreeNode(50);
        TreeNode left31 = new TreeNode(20);
        TreeNode right31 = new TreeNode(35);
        TreeNode left32 = new TreeNode(45);
        TreeNode right32 = new TreeNode(60);
        TreeNode left41 = new TreeNode(10);
        TreeNode left42 = new TreeNode(32);
        TreeNode right41 = new TreeNode(36);

        root.left = left2;
        root.right = right2;

        left2.left = left31;
        left2.right = right31;

        right2.left = left32;
        right2.right = right32;

        left31.left = left41;
        right31.left = left42;
        right31.right = right41;


        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);

        while (iterator.hasNext()) {
            System.out.printf(iterator.next() + " ");
        }


    }
}

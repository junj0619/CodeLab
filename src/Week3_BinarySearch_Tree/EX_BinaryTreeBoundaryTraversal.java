import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeBoundaryTraversal {


//         ______30______
//        /              \
//     __20__          __40__
//    /      \        /      \
//   10      25      35      50
//  /  \       \            /
// 5   15      28          41
//
// Output: [30, 20, 10, 5, 15, 28, 35, 41, 50, 40]
//
//
//         ______30______
//        /              \
//       20__          __40
//           \        /
//           25      35
//             \     /
//             28   41
//
// Output: [30, 20, 25, 28, 41, 35, 40]
//
//
//           ____30____
//          /          \
//       __20          40__
//      /                  \
//    _25                  35__
//   /                         \
//  28                          41
//
// Output: [30, 20, 25, 28, 41, 35, 40]
//
//         ______30______
//        /              \
//     __20__          __40__
//    /      \        /      \
//   10      25      35      50
//  /  \    /  \    /  \     / \
// 5   15  30   28 34  36   41  60
//
// Output: [30, 20, 10, 5, 15, 30, 28, 34, 36, 41, 60, 50, 40]
//
//
//    _______________28_______________
//   /                                \
//   4____                        ____69
//        \                      /
//      __8__                __56__
//     /     \              /      \
//   __7     12__        __34    __27__
//  /            \      /       /      \
//  5_          _13    _2      _3      39
//    \        /      /       /
//     6      11     10       9
//
//
// Output:[28, 4, 8, 7, 5, 6, 11, 10, 9, 39, 27, 56, 69]
//  PreOrder:[28, 4, NULL, 8, 7, 5, NULL, 6, NULL, NULL, NULL, 12, NULL, 13, 11, NULL, NULL, NULL,
// 69, 56, 34, 2, 10, NULL, NULL, NULL, NULL, 27, 3, 9, NULL, NULL, NULL, 39, NULL, NULL, NULL]
// level 4 => 2^4 - 1 nodes ==> 2^n - 1
//
// Test Cases 4/4
// Solution: Divide input tree to left sub and right sub
//           In left tree only add leftMost edge and leafs into result
//           In right tree only add rightMost edge and leafs into stack
//           Result = root.val +leftTree result + pop elements from rightTree stacks
//
   static class traversal{
        boolean isLeaf;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(30);
//        TreeNode node20 = new TreeNode(20);
//        TreeNode node10 = new TreeNode(10);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node25 = new TreeNode(25);
//        TreeNode node28 = new TreeNode(28);
//        TreeNode node40 = new TreeNode(40);
//        TreeNode node35 = new TreeNode(35);
//        TreeNode node50 = new TreeNode(50);
//        TreeNode node41 = new TreeNode(41);
//        TreeNode node30 = new TreeNode(30);
//        TreeNode node34 = new TreeNode(34);
//        TreeNode node36 = new TreeNode(36);
//        TreeNode node60 = new TreeNode(60);


//        //Test Case 1
//        root.left = node20;
//        root.right = node40;
//
//        node20.left = node10;
//        node20.right = node25;
//
//        node10.left = node5;
//        node10.right = node15;
//
//        node25.right = node28;
//
//        node40.left = node35;
//        node40.right = node50;
//
//        node50.left = node41;

        //Test case 2
//        root.left = node20;
//        root.right = node40;
//
//        node20.right = node25;
//        node25.right = node28;
//
//        node40.left = node35;
//        node35.left = node41;

        //Test case 3
//        root.left = node20;
//        root.right = node40;
//
//        node20.left = node25;
//        node25.left = node28;
//
//        node40.right = node35;
//        node35.right = node41;


//        //Test Case 4
//        root.left = node20;
//        root.right = node40;
//
//        node20.left = node10;
//        node20.right = node25;
//
//        node10.left = node5;
//        node10.right = node15;
//
//        node25.left = node30;
//        node25.right = node28;
//
//        node40.left = node35;
//        node40.right = node50;
//
//        node35.left = node34;
//        node35.right = node36;
//
//        node50.left = node41;
//        node50.right = node60;


        //Test case 5
        String input = "28, 4, NULL, 8, 7, 5, NULL, 6, NULL, NULL, NULL, 12, NULL, 13, 11, NULL, NULL,NULL," +
                "69, 56, 34, 2, 10, NULL, NULL, NULL, NULL, 27, 3, 9, NULL, NULL, NULL, 39, NULL, NULL, NULL";
        input = input.replace(" ","").replace("NULL","Null");

        TreeNode root = SerializeAndDeserializeBT.deserialize(input);
        
        String res = BTBoundaryTraversal(root);
        System.out.println(res);
    }

    public static String BTBoundaryTraversal(TreeNode root){
       if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        traversal trvl = new traversal();
        list.add(root.val); // add root node into result
        //trvl.isLeaf default is false
        traversalLeft(root.left, trvl, list);  // traversal left sub tree

        LinkedList<Integer> stack = new LinkedList<>();
        trvl.isLeaf = false;
        traversalRight(root.right, trvl, stack); // traversal right sub tree

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        for (Integer num : list) {
            sb.append(num + ",");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private static void traversalLeft(TreeNode root, traversal obj, List<Integer> list){
        if(root.left == null && root.right == null){
            obj.isLeaf = true;
            list.add(root.val);
            return;
        }

        if(!obj.isLeaf)
            list.add(root.val);

        if(root.left != null)
            traversalLeft(root.left, obj, list);
        if(root.right != null)
            traversalLeft(root.right, obj, list);
    }

    private static void traversalRight(TreeNode root, traversal obj, LinkedList<Integer> stack) {
        if (root.left == null && root.right == null) {
            obj.isLeaf = true;
            stack.push(root.val);
            return;
        }

        if (!obj.isLeaf)
            stack.push(root.val);

        if (root.right != null)
            traversalRight(root.right, obj, stack);
        if (root.left != null)
            traversalRight(root.left, obj, stack);
    }

}

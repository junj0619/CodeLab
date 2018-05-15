class Solution {
    class Node {
        int val;
        int count = 1;
        int leftCount;
        Node left, right;
        
        public Node(int val, int leftCount) {
            this.val = val;
            this.leftCount = leftCount;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
       
        int len = nums.length;
        Integer[] count = new Integer[len];
        Node root = null;
        
        for (int i = len - 1; i >= 0; i--) {
            root = buildBST(root, nums[i], 0, count, i);
        }
        
        return Arrays.asList(count);        
    }
    
    private Node buildBST(Node root, int val, int leftCount, Integer[] count, int index) {
        if (root == null) {    
            count[index] = leftCount;
            return new Node(val, 0);
        }
        
        if (root.val > val) {
            root.leftCount++;         
            root.left = buildBST(root.left, val, leftCount, count, index);
        } else if (root.val < val) {
            root.right = buildBST(root.right, val, root.count + root.leftCount + leftCount, count, index);
        } else {
            root.count++;
            count[index] = leftCount + root.leftCount;
        }
        return root;
    }
}

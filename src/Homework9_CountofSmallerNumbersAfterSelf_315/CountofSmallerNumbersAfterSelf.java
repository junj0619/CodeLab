public class Solution {
    class Node {
        int sum; // total of number on it's left bottom side
        int dup; // appear time
        Node left,right;        
        int val;
        
        Node(int val, int sum){
            this.val = val;            
            this.dup = 1;
            this.sum = sum;
        }
            
    }
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        Node root = null;
        Integer[] res = new Integer[len];
        
        for (int i = len - 1; i >= 0; i--) {
          root = insert(nums[i], i, root, 0, res);
        }
        
        return Arrays.asList(res);        
    }
    
    public Node insert(int num, int i, Node root, int preSum, Integer[] res){
        if (root == null) { 
            res[i] = preSum; //insert new node
            return new Node(num, 0);
        }
        
        if (num > root.val) { //go right ,then calculate sum + dup
            root.right = insert(num, i, root.right, preSum + root.sum + root.dup, res);                            
        } else if (num < root.val) {
            root.sum++; //go left then find a smaller number so sum++
            root.left = insert(num, i, root.left, preSum, res); 
        } else {
            root.dup++; //find same number then update dup and re calculate result = this result:preSum + pre result: root.sum
            res[i] = preSum + root.sum;
        }
        
        return root;    
    }
}

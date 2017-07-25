public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {              
        
        if(nums == null || k <= 0) return new int[0];
        
        int n = nums.length;  
        int curr = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            //Remove out of range [i - (k - 1), i], remove head element from deque
            while(!deque.isEmpty() && deque.peek() < (i - (k - 1))) {
                deque.poll();
            }
            
            //remove smaller element in k size range
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
            
            //generate res from (k - 1)
            if(i >= k - 1) {
                res[curr++] = nums[deque.peek()];
            }
        }
        
        return res;
    }
}

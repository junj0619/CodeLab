public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        //First Step: Sort array because if nums[i] < nums[j] then nums[i] % nums[j] for sure not equal 0
        //So the problem become only check nums[j] % nums[i] == 0 
        Arrays.sort(nums);
        
        //Generate dp array
        //[1, 2, 3]
        //dp[0] = 1
        //dp[1] = 2 [1, 2]
        //dp[2] = 2 [1, 3]
        
        //[1, 2, 4, 8]
        //dp[0] = 1
        //dp[1] = 2 [1, 2]
        //dp[2] = 3 [1, 2, 4]
        //dp[3] = 4 [1, 2, 4, 8]
        int dp[] = new int[nums.length];
        dp[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {              //Input:   [2,3,8,9,27]
            dp[i] = 1;                                       //Output:  [8,2]
            for (int j = i - 1; j >= 0; j--) {               //Expected:[3,9,27]
                if(nums[i] % nums[j] == 0) {                
                    dp[i] = Math.max(dp[i], dp[j] + 1);                    
                }                
            }
        }
        
        //Second Step: Find max value in DP array. Then put the numbers which before max position 
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
        
        //[3,4,16,8]
        //sorted => [3, 4, 8, 16]
        //dp[0] = 1
        //dp[1] = 0
        //dp[2] = 2 [4, 8]
        //dp[3] = 3 [4, 8, 16]
        //maxIndex = 3
        int temp = nums[maxIndex];
        int curDP = dp[maxIndex];
        //backtracking???
        for (int i = maxIndex; i >= 0; i--) {
            if(temp % nums[i] == 0 && dp[i] == curDP) {
                res.add(nums[i]);
                temp = nums[i]; //??
                curDP--;        //??
            }
        }
        
        return res;        
    }
}

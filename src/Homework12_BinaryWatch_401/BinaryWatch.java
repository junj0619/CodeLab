class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        
        int[] hrs = {8, 4, 2, 1};
        int[] mins = {32, 16, 8, 4, 2, 1};
        
        for (int i = 0; i <= num; i++) {            
            List<Integer> hrsList = getDigit(hrs, i);
            List<Integer> minsList = getDigit(mins, num - i);
            
            for (Integer hr : hrsList) {
                if (hr > 11) continue;
                for (Integer min : minsList) {
                    if (min > 59) continue;
                    res.add(hr + ":" + (min < 10 ? "0" + min : min));
                }
            }        
        }
        
        return res;
        
    }
    
    public List<Integer> getDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        getDigitHelper(nums, count, 0, 0, res);
        return res;
    }
    
    public void getDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return; 
        }
        
        for (int i = pos; i < nums.length; i++) {
            getDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }
    
}

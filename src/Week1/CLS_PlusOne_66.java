class Solution {
    public int[] plusOne(int[] digits) {
        //[9, 9, 9] => [1, 0, 0, 0]
        //[9, 9, 8] => [9, 9, 9]
        //[8, 9, 9] => [9, 0, 0]
        //[0] => [1]
        
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] result = new int[size + 1];
        result[0] = 1;
        return result;
    }
}

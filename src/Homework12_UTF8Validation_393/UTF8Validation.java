//https://discuss.leetcode.com/topic/58338/bit-manipulation-java-6ms/4
/*
*   Char. number range  |        UTF-8 octet sequence
*      (hexadecimal)    |              (binary)
*   --------------------+---------------------------------------------
*   0000 0000-0000 007F | 0xxxxxxx
*   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
*   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
*   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
* Rule 2:
* Record the count of consecutive of 1.
* Move the number 5 bit right, if it equals "110" means there is one '1'.
* Move the number 4 bit right, if it equals "1110" means there are two '1'.
* ...
* Move the number 7 bit right, if it equals "1" means it is "10000000" which has no meaning, return false.
*
* Rule 1:
* If it is not started with "10", return false;
*/
class Solution {
    public boolean validUtf8(int[] data) {
        
        int count = 0;
        
        for (int d: data) {
            if (count == 0) {
                if (d >>> 5 == 0b110) count = 1;
                else if (d >>> 4 == 0b1110) count = 2;
                else if (d >>> 3 == 0b11110) count = 3;
                else if (d >>> 7 == 1) return false;
            } else {
                if (d >>> 6 != 0b10) return false;
                count--;
            }
        }
        return count == 0;
    }
}

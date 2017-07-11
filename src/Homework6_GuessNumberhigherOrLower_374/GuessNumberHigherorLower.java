/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
/**
*
* Beats : 16.25%
**/
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end  = n;
        
        while(start < end - 1) {
            int mid = (start + end) >>> 1;    
            int res = guess(mid);
            if(res == 0) {
                return mid;
            } else if(res == -1) {  //My number is lower than your guess!!!!!!              
               end = mid;
            } else {
               start = mid;
            }                        
        }
        
        return guess(start) == 0? start:end;
    }
}

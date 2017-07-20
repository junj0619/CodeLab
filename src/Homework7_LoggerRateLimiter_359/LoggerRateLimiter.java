/**
* Design a logger system that receive stream of messages along with its timestamps, 
* each message should be printed if and only if it is not printed in the last 10 seconds.
*
* Use HashMap<msg, timestamp> to check exist or not. If exist then check diff(timestamp).
* if diff >= 10 then update timestamp return ture; else return false;
* beats: 13.11%
*
**/

public class Logger {

    /** Initialize your data structure here. */        
    
    private HashMap<String, Integer> map; //Key : msg, Value: timestamp
    
    public Logger() {
      map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if (!map.containsKey(message)) {
           map.put(message, timestamp);
           return true;
        } else {
            Integer value = map.get(message);  
            boolean res = false;
            
            if (timestamp - value >= 10) {
                res = true;    
                map.put(message, timestamp);
            }         
            
            return res;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

## 735.Asteroid Collision ##


### Idea: ##
 Since given logic : 
        "Find out the state of the asteroids after all collisions. 
         1. If two asteroids meet, the smaller one will explode. 
         2. If both are the same size, both will explode. 
         3. Two asteroids moving in the same direction will never meet."
 So we may assume above actions will keep happening so 
 if No.1 action happen we have to what was last asteroids then we can decide the next logic.
 So the best way to track last store element will be **STACK**. 
 We can easily ask stack peek() value to check if previous and current asteroids are having collision.
 If yes then we can check which asteroid is greater, smaller or they are equal. 
 So by reach to this point we can put down the logic to  eliminate one of asteroids.
 
### Time Complexity: O(n)  ###  
Scan each element 
### Space Complexity: O(n)  ###  
Worest case: numbers in array are all postive or negative then each element will push to stack 

```java

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) 
            return asteroids;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < asteroids.length) {
            int val = asteroids[i]; 
            
           //Only way Collision can happen is (+) vs (-) under it we have 3 cases
            if (!stack.isEmpty() && stack.peek() >= 0 && val < 0) {                                   
                int top = stack.peek();
                if (top + val > 0) { //(+) > (-) then eliminate (-)
                    i++;                    
                } else if (top + val < 0) { //(+) < (-) then eliminate (+)
                    stack.pop();
                } else {  // (+) = (-) then eliminate both (+),(-)
                    i++;
                    stack.pop();                    
                }
            } //Stack isEmpty, same direction or (-) vs (+)
            else {                 
                stack.push(val);
                i++;                                                   
            }           
        }
        
        int size = stack.size();    
        int[] res = new int[size];    
        //Build result keep orginal order        
        for (int j = size - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }
}

```

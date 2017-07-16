/*
* Given two 1d vectors, implement an iterator to return their elements alternately.
*
* For example, given two 1d vectors:
* v1 = [1, 2]
* v2 = [3, 4, 5, 6]
* By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
*
*
* Input : [1],[]  
* Output: [1]
*
* Input : [], [1]
* Output: [1]
*
* Input : [1,2,3] 
*         [4,5,6,7]
* Output: [1,4,2,5,3,6,7]
*
* Input : [1,2,3]
*         [4,5,6]
* Output: [1,4,2,5,3,6]
*
* Input : [1,2,3,4] 
*         [5,6,7]
* Output: [1,5,2,6,3,7,4]
*
* Time Complexity: O(n) number of time call next()
* Space Complexity : O(1)
* Beats: 70.96%
*/

public class ZigzagIterator {

    private Iterator<Integer> i, j, temp;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next() {       
        if(i.hasNext()) {          
          temp = i;
          i = j;
          j = temp;
        }
        return j.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

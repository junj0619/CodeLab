/**
* Input: "L1e2c1o1d1e1"
* OutPut: "Leecode"
*
* Input: "X10A1"
* Output:"XXXXXXXXXXA"
*
* Input: "a1234567890b1234567890"
* Output: "aaaaa..............aaa"
*
* Keypoint: maintain two lists: char list and count list
*           next(): only decrease current char count or increase cur scan char pointer
*        hasNext(): check cur ptr is greater than char list size.
**/


public class StringIterator {
    private List<Character> charList;
    private List<Integer> countList; 
    private int ptr;
    
    public StringIterator(String compressedString) {
        charList = new ArrayList<>();
        countList = new ArrayList<>();        
        ptr = 0;
        int len = compressedString.length();        
        int i = 0;
        
        while(i < len) {
            charList.add(compressedString.charAt(i));
            int j = i + 1;
            while(j < len && Character.isDigit(compressedString.charAt(j))) {
                j++;
            }
            countList.add(Integer.parseInt(compressedString.substring(i + 1, j)));
            i = j;
        }        
    }
    
    public char next() {  
        if(!hasNext()) return ' ';
        
        char c = charList.get(ptr);
        int count = countList.get(ptr) - 1;
        countList.set(ptr, count);
        if(count == 0) { 
            ptr++;
        }
        
        return c;     
    }
    
    public boolean hasNext() { 
        return ptr < charList.size();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */



public class Solution {
    class UnionFind {
        public int[] un;
        UnionFind(int size) {
            un = new int[size];
            for(int i = 0; i < un.length; i++) {   //initial union array: like [0, 1, 2, 3, 4, 5, 6, 7, 8]
                un[i] = i;
            }
            
        }
        
       public void union(int i, int j){  //Union means [0, 1]  set 1 parent to be 0. Or set 0 parent to be 1.
            int parentI = find(i);       //Then union array will be [0, 0, 2, 3, 4, 5, 6, 7, 8]
            int parentJ = find(j);       //Union [1,2] since 1's parent is 0 and 2's parent is 2 so they are not equal.
                                         //Then repeat same process set 2's parent to 0's parent 
            if(parentI != parentJ) {     //Union array will be [0, 0, 0, 3, 4, 5, 6, 7, 8]           
                un[parentJ] = parentI;   
            }                                
        }
        
       public int find(int n){
            while(n != un[n]) {
                n = un[n];
            }
            return n;
        }
        
    }
    
    
    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);        
        int count;
        for(int row = 0; row < M.length; row++) {
            for(int col = 0; col < M[0].length; col++) {
                if(row != col && M[row][col] == 1) {
                    unionFind.union(row, col);
                }
            }                
        }
        
        int [] unArr = unionFind.un;
        HashSet<Integer> set = new HashSet<>();
        
        for(int k = 0; k < unArr.length; k++) {            
             unArr[k] = unionFind.find(k);            
        }
        
        for(int i = 0; i < unArr.length; i++) {
            if(!set.contains(unArr[i])) {
                set.add(unArr[i]);
            }
        }
        
        return set.size();
    }
    

}



public class Solution {
    class UnionFind {
        public int[] un;
        UnionFind(int size) {
            un = new int[size];
            for(int i = 0; i < un.length; i++) {   //initial union array: like [0,1,2,3,4,5,6,7,8]
                un[i] = i;
            }
            
        }
        
       public void union(int i, int j){
            int parentI = find(i);   
            int parentJ = find(j);
            
            if(parentI != parentJ) {                
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

class Solution {
    class UnionFind {
        public int[] un;
        public UnionFind(int size) {
            un = new int[size];
            for (int i = 0; i < size; i++) {
                un[i] = i;
            }
        }
        
        public void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            
            if (parentI != parentJ) {
                un[parentJ] = parentI;
            }
        }
        
        public int find(int n) {
            while (n != un[n]) {
                n = un[n];
            }            
            return n;
        }        
    }
    
    
    public int findCircleNum(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        
        Set<Integer> set = new HashSet<>();
        UnionFind uf = new UnionFind(rows);   
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row != col && M[row][col] == 1) {
                    uf.union(row, col);
                }
            }
        }
        
        for (int u : uf.un) {
            int parent = uf.find(u);
            if (!set.contains(parent)) {
                set.add(parent);
            }
        }
        
        return set.size();        
    }
}

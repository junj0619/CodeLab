class Solution {
//Backtracking 1
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        
        dfs(n, k, 1, set, res);
        return res;
    }
    
    private void dfs(int n, int k, int start, List<Integer> set, List<List<Integer>> res) {
        if (set.size() == k) {
            res.add(new ArrayList<Integer>(set));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            set.add(i);
            dfs(n, k, i + 1, set, res);
            set.remove(set.size() - 1);
        }
    }
}

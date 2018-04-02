class Solution {    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (int[] a, int b[]) -> { return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]; });
        
        for (int i = 0; i < nums1.length && k > i; i++) queue.offer(new int[] {i, 0});
        
        
        while (!queue.isEmpty() && res.size() < k) {
            int[] pair = queue.poll();
            res.add(new int[] { nums1[pair[0]], nums2[pair[1]] });
            
            if (pair[1] + 1 < nums2.length) {
                queue.offer(new int[] {pair[0], pair[1] + 1});
            }
        }
        
        return res;
    }
}

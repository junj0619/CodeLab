class Solution {
//HashMap + MaxHeap
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return res;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
                                                                                 /* Descend sort by PQ value */
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);    
        }
        
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.remove().getKey());
        }
        return res;
    }
}

//Bucket Sort Pending to Learn

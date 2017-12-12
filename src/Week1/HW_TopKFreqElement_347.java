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

//Bucket Sort: Time Complexity: O(n)
//Use element frequence as Index then comb the result.
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return result;
        
        HashMap<Integer, Integer> map = new HashMap<>();        
       
        //Conern case nums all same. eg:[1,1,1,1,1,1] k = 1 
        //Then map is <1, 6>. in line of map.get(1) = 6 but bucket size is only 1
        List<Integer>[] bucket = new List[nums.length + 1];
            
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);            
        }
        
        //Corner case nums all same. eg:[1,1,1,1,1,1] k = 1 
        //Then map is <1, 6>. in line of map.get(1) = 6 but bucket size is only 1
        //List<Integer>[] bucket = new List[map.size() + 1];
        
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(n);
        }
        
        for (int i = bucket.length - 1; i > 0 && k > 0 ; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                // Corner cases two element has same freq
                // e.g: [1, 1, 2, 2, 3, 4] , k = 2
                // Expect: [1, 2]
                // But if only use k--; 
                // Wrong Result: [1, 2, 3, 4]
                k = k - bucket[i].size();  
            }
        }
        
        return result;
    }
}

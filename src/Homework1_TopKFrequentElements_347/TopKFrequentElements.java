package Homework1_TopKFrequentElements_347;

import java.util.*;

/**
 * Created by junjin on 6/6/17.
 *
 * Given a non-empty array of integers, return the k most frequent elements.

 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * Input : [1,1,1,2,2,3] ,k=2
 * OutPut: [1,2]
 *
 * Input : [1,1,1,2,2,2], k=1
 * OutPut: [1] ???? same frequency.
 *
 * Input : [1,1,1,2,2,2], k=2
 * OutPut: [1,2]
 *
 * Input : [1],K=1
 * Output: [1]
 *
 * Input : [1,1,2,2,3,3,3], k=3
 * Output: [3,2,1]
 *
 * Time Complexity : O(N) N + Distinct(N) + K
 * Space Complexity: O(N) HashMap N + maxHeap N + ArrayList K
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 119 ms
 * Beats  : 6.73%
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(); //Key: num, Value: frequent

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //Build maxHeap base on HashMap value. Element frequency.
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        //loop hashMap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        ArrayList<Integer> list = new ArrayList<>();

        //get Top K element from maxHeap
        for (int i = 0; i < k; i++) {
            list.add(maxHeap.remove().getKey());
        }

        return list;
    }
}

<h2>LeetCode 213. House Robber II</h2>
<h3>Questions</h3>

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are **arranged in a circle**. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and **it will automatically contact the police if two adjacent houses were broken into on the same night.**
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police.**

**Example 1:**
<pre><b>Input:</b> [2,3,2]
<b>Output:</b> 3
<b>Explanation:</b> You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),  
             because they are adjacent houses..  </pre>


**Example 2:**  
<pre>
<b>Input:</b> [1,2,3,1]  
<b>Output:</b> 4   
<b>Explanation:</b> Rob house 1 (money = 1) and then rob house 3 (money = 3).  
             Total amount you can rob = 1 + 3 = 4.  
</pre>


<h2>Thinking</h2>

This question is smailer to House Robber I. Only difference is that the houses in House Robber II are in the circle which means we can not select both **first and last** houses at the same time. We use same idea to analyze the question. Let’s say we have n houses.  
* If we select 1st house then the max robber value in 1 to n - 1.
* If we don’t select 1st house then the max robber value in 2 to n. 
In this way we can see the answer must be in one of these sub problems. Meanwhile we remove the circle constraint. Rest of sub problems will be same as House Robber I. We can maintain a memorization array to save maximum robber value of current house (1 to current house maximum robber value). Then after fill up all the house, the maximum robber solution value in the last element of memorization. Following example explain the fill up process.  
**Time Complexity: O(N)** use Rob1 twice each call will be O(N) time complexity overall 2N = N.
**Space Complexity: O(N)** create two DP arrays to save calculated solution.   

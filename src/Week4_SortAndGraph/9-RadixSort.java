public class RadixSort {
/*
*   Time Complexity: O(nd)  => n is length of input, d is max num length 
*   Space Complexity: O(nd) 
*   Stable: Y (must stable to make RadixSort work)  => eg. 123, 121, 124
*
*/
	public int[] sort(int[] nums) {
		for (int i = 1; i < 1000000000; i *= 10) { //Largest place for a 32-bit int is 1's billions space. 
			nums = countingSort(nums, i);
		}
		return nums;
	}

	private int[] countingSort(int[] nums, int pos) {
		int[] count = new int[10]; // 0-9
		int[] res = new int[nums.length];
		for (int num : nums) {
			count[getDigit(num, pos)]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int j = nums.length - 1; j >= 0; j--) {
			res[--count[getDigit(nums[j], pos)]] = nums[j];
		}

		return res;
	}

	private int getDigit(int num, int pos) {
		return num / pos % 10;
	}

}

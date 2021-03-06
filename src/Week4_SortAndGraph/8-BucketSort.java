import java.util.ArrayList;

/*
* Time Complexity: O(n + r)
* Space Complexity: O(n + r)
* Stable: YES
*/

public class BucketSort {
	private static int SIZE = 30;

	public void sort(int[] nums) {
		int min = 0;
		int max = 0;

		for (int num : nums) {
			if (min > num)
				min = num;
			if (max < num)
				max = num;
		}

	    //Initialization
		ArrayList<ListNode> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			ListNode node = new ListNode(Integer.MAX_VALUE);
			list.add(node);
		}
		
		//Put into bucket
		for (int num : nums) {
			ListNode head = list.get(buildIndex(num, min, max));
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			head = dummy;

			while (head.next.val <= num)  //  "<=" will make sort stable
				head = head.next;

			ListNode newNode = new ListNode(num);
			newNode.next = head.next;
			head.next = newNode;
			list.set(buildIndex(num, min, max), dummy.next);
		}

		//Generate result
		int index = 0;
		for (ListNode node : list) {
			while (node.val != Integer.MAX_VALUE) {
				nums[index++] = node.val;
				node = node.next;
			}
		}
	}
	
	//Get bucket Index
	private int buildIndex(int num, int min, int max) {
		return (num - min) * SIZE / (max - min + 1);
	}

}

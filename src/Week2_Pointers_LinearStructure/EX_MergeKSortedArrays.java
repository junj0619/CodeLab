import java.util.PriorityQueue;

class QueueNode {
    public int arrIndex, eleIndex, value;

    public QueueNode(int arrIndex, int eleIndex, int value) {
        this.arrIndex = arrIndex;
        this.eleIndex = eleIndex;
        this.value = value;
    }
}

public class MergeKSortedArrays {


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2},
                {3, 4, 5, 6},
                {7, 8, 9, 10},
                {11, 12, 13}
        };

        int[] nums = merge(arr);

        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    public static int[] merge(int[][] arr) {

        int size = 0; //result arr size;
        PriorityQueue<QueueNode> pq = new PriorityQueue<>((x, y) -> x.value - y.value); //MinHeap with k size (if each sub array are same size)

        for (int i = 0; i < arr.length; i++) {
            size += arr[i].length;
            pq.add(new QueueNode(i, 0, arr[i][0])); //Add first element into MinHeap from each sub arrs
        }

        int[] res = new int[size];

        for (int i = 0; !pq.isEmpty(); i++) {
            QueueNode node = pq.poll();
            res[i] = node.value;
            int nextIndex = node.eleIndex + 1; //Find next available element in current array

            if (nextIndex < arr[node.arrIndex].length) { //add next available queueNode into MinHeap
                pq.add(new QueueNode(node.arrIndex, nextIndex, arr[node.arrIndex][nextIndex]));
            }
        }

        return res;
    }


}

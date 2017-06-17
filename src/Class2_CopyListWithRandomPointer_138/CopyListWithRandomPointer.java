package Class2_CopyListWithRandomPointer_138;

import java.util.HashMap;

/**
 * Created by junjin on 6/15/17.
 *          _________      ____
 *         |         |    |    |    L -> R:
 * Input : 1 -> 2 -> 3 -> 4 -> 5    Random Pointer: 1 -> 3, 2 -> 4, 3 -> 5, 4 -> 5, 5 -> null
 *              |____|____|    |
 *                   |_________|
 * Input : 1 -> Null
 *
 * Input : Null
 *
 * Input : 1 -> 2 -> 3 -> 4 -> 5   L -> R:
 *         |____|____|____|____|   Random Pointer: 1 -> null, 2 -> 1, 3 -> 1, 4 -> 1, 5 -> 1
 *
 * Input : 1 -> 2                  L -> R:
 *         ^    ^                  Random Pointer: 1 -> 2, 2 -> 1
 *         |____|
 */
public class CopyListWithRandomPointer {


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node4;
        node3.random = node5;
        node4.random = node5;
        node5.random = node1;

        RandomListNode copyNode = copy(node1);
        RandomListNode node = copyNode;

        while(node != null) {
            System.out.printf(node.label +" -> ");
            node = node.next;
        }
        System.out.println();
        node = copyNode;
        while(node != null){
            if(node.random != null){
                System.out.printf(node.random.label + " -> ");
            }
            node = node.next;
        }

    }


    /*
     KeyPoint to Solve:
       1) How to copy cur and next ,then link them together?
       A: Each iteration we can get cur and cur.next.
          Then create curCopy and nextCopy.
          Then link them together

       2) How to copy random node and link it with the node?
       A: When access each node we can get the node random node.
          Then we can create random node copy. And linked it to the curCopy.
          But random node could point to existing copyNode or future copyNode.
       Issue:
         1) Link new random node may causing issue to point wrong node reference.
         2) Creating new random may causing duplicated nodes.

         So we should check if copy node already created in previous iteration.
         We shouldn't create it again in reset of iteration.
         Then we can use a HashSet as data structure to check whether copy node exists or not.
         Then we solved checking node exist or not.

         But random node issue still not solved yet. We can not find random node copy from HashSet
         Then we can use HashMap to save <node,nodeCopy> in HashMap.
         Then use map.get(node.random) to get random node copy.


       3) How to get current copy random node?
       A: Current copy random node can be got from HashMap.
          map.get(node.random);


     HashMap Logic:
       1) Create current node, then put current node and copy into HashMap.
                                     (if map doesn't contains current node)
       2) Create next node, then put current next node and copy into HashMap.
                                     (if map doesn't contains next node)
       3) Create random node, then put random node and copy into HashMap.
                                     (if map doesn't contains random node)
       4) Create currentCopy->nextCopy, currentCopy->randomCopy
     */



    //Two Pass HashMap
    public static RandomListNode copy(RandomListNode head) {

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>(); //Key:original,Value:Copy
        RandomListNode node = head;

        //first pass copy cur and next
        while (node != null) {
            //Creating cur node
            if (!map.containsKey(node)) {
                map.put(node, new RandomListNode(node.label));
            }

            //Creating next node
            if (node.next != null && !map.containsKey(node.next)) {
                map.put(node.next, new RandomListNode(node.next.label));
            }

            //Create copy->copy.next
            map.get(node).next = map.get(node.next);
            node = node.next;
        }

        //second pass copy random pointer
        node = head;
        while (node != null) {
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    //One Pass HashMap
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode cur = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>(); //Key: Originial, Value: Copy

        while(cur != null){
            //Copy current node
            if(!map.containsKey(cur)){
                RandomListNode curCopy =  new RandomListNode(cur.label);
                map.put(cur, curCopy);
            }
            //Copy next node
            if(cur.next != null && !map.containsKey(cur.next)){
                RandomListNode nextCopy = new RandomListNode(cur.next.label);
                map.put(cur.next, nextCopy);
            }
            //Copy random node
            if(cur.random != null && !map.containsKey(cur.random)){
                RandomListNode randomCopy = new RandomListNode(cur.random.label);
                map.put(cur.random, randomCopy);
            }

            //Create mapping of copy to next and random.
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //One Pass In-Place
    public RandomListNode copyRandomListInPlace(RandomListNode head){

        //step 1: copy current node in the next position
        RandomListNode node = head;
        while(node != null){
            RandomListNode copy = new RandomListNode(node.label);
            RandomListNode next = node.next;
            node.next = copy;
            copy.next = next;
            node = next;
        }

        //step 2: link copy random pointer
        node = head;
        while(node != null && node.next != null){
            RandomListNode next = node.next.next;
            if(node.random != null){       //[1,#] no random. so have to check this case
                node.next.random = node.random.next;
            }
            node = next;
        }

        //step 3: rebuild link list to CopyLinkedList and Original LinkedList
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copy = dummyHead;
        RandomListNode original = head;
        node = head;
        while(node != null && node.next != null){
            RandomListNode next = node.next.next;
            copy.next = node.next;
            original.next = next;

            copy = copy.next;
            original = original.next;
            node = next;
        }

        return dummyHead.next;
    }
}

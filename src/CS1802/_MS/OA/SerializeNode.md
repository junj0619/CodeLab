```java
public class TreeNode {
  public TreeNode left;
  public TreeNode right;
  object theData;
}

//Binary Tree
//        1          => [[1], [2,3], [4,NULL,6,7]]
//     /      \      
//    2        3       pre-order: 1,2,4,3,6,7 
																  0,1,2,3,4,5    Left = 2 * i + 1, Right = 2 * i + 2
//   / \      /  \      in-order: 4,2,1,6,3,7
//  4   NULL  6   7   post-order: 4,2,6,7,3,1
                                  0,1,2,3,4,5  

public class ListNode {
  int left;
  int right;
  object theData;
}                                    
                                    
                                    
public ArrayList<ListNode> Serialize(TreeNode root) {
  if (root == null)
  {
    return null;
  }
  ArrayList<ListNode> theList = new ArrayList<ListNode>();
  SeralizeInteral(root, theList);
  
  return theList; 
}

public int SeralizeInteral(TreeNode subRoot, ArrayList<ListNode> theList)
{
  ListNode newNode = new ListNode(subRoot.theData);
  if (subRoot.Left != null)
  {
    newNode.Left = SeralizeInternal(subRoot.Left, theList);
  }
  else
  {
    newNode.Left = -1;
  }
   
  if (subRoot.Right != null)
  {
    newNode.Right = SeralizeInternal(subRoot.Right, theList);
  }
  else
  {
    newNode.Right = -1;
  }
  
  theList.Add(newNode);
  return list.Length() - 1;
}

```

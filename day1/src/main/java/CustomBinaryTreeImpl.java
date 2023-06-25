import java.util.LinkedList;
import java.util.Queue;

public class CustomBinaryTreeImpl {
	Node root;
	  // Traverse tree
	

	/* Array1 = [1, 3, 2, 5]
	 * 			
	 * 			    1
	 * 			   / \
	 * 			  3   2
	 * 			 /   
	 * 			5   
	 * 
	 * 
	 * 
	 * Array2 = [2,1,3,null,4,null,7]
	 * 
	 * 				  2
	 * 				 / \
	 * 				1   3
	 * 				 \   \
	 * 				   4   7
	 * 
	 * 
	 *     i

	    /     \
	(2*i+1)   (2*i+2)
	 * 
	 * 
	 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
	   Output: [3,4,5,5,4,null,7]

	 * 
	 */
	private int height(Node root) {
		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static Node createTree(String[] arr, int i) {
		Node root = null;
		// Base case for recursion
		if (i < arr.length) {
			root = new Node(arr[i]);

			// insert left child
			root.left = createTree(arr, 2 * i + 1);

			// insert right child
			root.right = createTree(arr, 2 * i + 2);
		}
		return root;
	}

	public void traverseTree(Node node) {
		if (node != null) {
			traverseTree(node.left);
			System.out.print(" " + node.data);
			traverseTree(node.right);
		}
	}

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public static void preOrder(Node root) {
		if (root != null) {
			preOrder(root.left);
			preOrder(root.right);
			System.out.print(root.data + " ");

		}
	}



	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.right);
			System.out.print(root.data + " ");
			postOrder(root.left);

		}
	}

	public static Node bstInsert(Node node, String data) {
		/*
		 * When there no node in the tree(subtree) then create and return new node using
		 * newNode function
		 */
		if (node == null)
			return new Node(data);

		/* If not then we recur down the tree to find correct position for insertion */
		if (Integer.parseInt(data) < Integer.parseInt(node.data))
			node.left = bstInsert(node.left, data);
		else if (Integer.parseInt(data) > Integer.parseInt(node.data))
			node.right = bstInsert(node.right, data);

		return node;
	}

	public Node searchNode(Node root, String value) {
		if (root == null)
			return null;
		if (root.data.equals(value)) // return true if value is found in binary tree
			return root;
		else if (Integer.parseInt(value) < Integer.parseInt(root.data))
			return searchNode(root.left, value); // traverse left subtree
		else if (Integer.parseInt(value) > Integer.parseInt(root.data))
			return searchNode(root.right, value); // traverse right subtree
		return root;
	}

	public String minimumValue(Node ptr) {
		String min;
		for (min = ptr.data; ptr.right != null; ptr = ptr.right)
			min = ptr.right.data;
		return min;
	}

	public void delete(String value) {
		root = deleteNode(root, value); // calling deleteNode() method
	}
	
	public String largestElement(Node temp)  
    {    
        //Check whether tree is empty    
         if(root == null)   
         {    
             System.out.println("Tree is empty");    
             return null;    
          }    
         else  
         {    
        	 String leftMax, rightMax;    
             //Max will store temp's data    
        	 String max = temp.data;    
             //It will find largest element in left subtree    
             if(temp.left != null){    
                 leftMax = largestElement(temp.left);    
                 //Compare max with leftMax and store greater value into max    
                 max = String.valueOf(Math.max(Integer.parseInt(max), Integer.parseInt(leftMax)));    
              }    
              //It will find largest element in right subtree    
              if(temp.right != null){    
                  rightMax = largestElement(temp.right);    
                  //Compare max with rightMax and store greater value into max    
                  max = String.valueOf(Math.max(Integer.parseInt(max), Integer.parseInt(rightMax)));    
                   }    
              return max;    
         }    
    }    
	public String smallestElement(Node temp)  
    {    
        //Check whether tree is empty    
         if(root == null)   
         {    
             System.out.println("Tree is empty");    
             return null;    
          }    
         else  
         {    
        	 String leftMin, rightMin;    
             //Max will store temp's data    
        	 String min = temp.data;    
             //It will find largest element in left subtree    
             if(temp.left != null){    
                 leftMin = largestElement(temp.left);    
                 //Compare max with leftMax and store greater value into max    
                 min = String.valueOf(Math.min(Integer.parseInt(min), Integer.parseInt(leftMin)));    
              }    
              //It will find largest element in right subtree    
              if(temp.right != null){    
                  rightMin = largestElement(temp.right);    
                  //Compare max with rightMax and store greater value into max    
                  min = String.valueOf(Math.max(Integer.parseInt(min), Integer.parseInt(rightMin)));    
                   }    
              return min;    
         }    
    }    

	public int findMaximumWidth()   
    {    
        int maxWidth = 0;    
        //Variable nodesInLevel keep tracks of number of nodes in each level    
        int nodesInLevel = 0;    
        //queue will be used to keep track of nodes of tree level-wise    
        Queue<Node> queue = new LinkedList<Node>();    
        //Check if root is null, then width will be 0    
        if(root == null) {    
            System.out.println("Tree is empty");    
            return 0;    
        }    
        else   
        {    
            //Add root node to queue as it represents the first level    
            queue.add(root);   
            while(queue.size() != 0)   
            {    
                //Variable nodesInLevel will hold the size of queue i.e. number of elements in queue    
                nodesInLevel = queue.size();    
                //maxWidth will hold maximum width.     
                //If nodesInLevel is greater than maxWidth then, maxWidth will hold the value of nodesInLevel    
                maxWidth = Math.max(maxWidth, nodesInLevel);    
                //If variable nodesInLevel contains more than one node     
                //then, for each node, we'll add left and right child of the node to the queue    
                while(nodesInLevel > 0)   
                {    
                   Node current = queue.remove();    
                   if(current.left != null)     
                       queue.add(current.left);    
                   if(current.right != null)     
                       queue.add(current.right);    
                   nodesInLevel--;    
                }    
            }    
        }    
        return maxWidth;    
    }    
	public Node deleteNode(Node ptr, String value) {
		if (ptr == null)
			return ptr;
		if (Integer.parseInt(value) > Integer.parseInt(ptr.data)) // if value if greater than current value
			ptr.right = deleteNode(ptr.right, value);
		else {
			// if node having max one child
			if (ptr.left == null)
				return ptr.right;
			else if (ptr.right == null)
				return ptr.left;
			// if node having two children then get the inorder predecessor of node
			ptr.data = minimumValue(ptr.left);
			// delete the inorder predecessor
			ptr.left = deleteNode(ptr.left, ptr.data);
		}
		return ptr;
	}




	private static void extracted1() {
		Node node = null;
		node = bstInsert(node, 9 + "");
		bstInsert(node, 7 + "");
		bstInsert(node, 5 + "");
		bstInsert(node, 8 + "");
		bstInsert(node, 14 + "");
		bstInsert(node, 11 + "");
		bstInsert(node, 16 + "");
		System.out.println("The postorder is :\n");
		postOrder(node);

		System.out.println("\nThe preorder is :\n");
		preOrder(node);

		System.out.println("\nThe inorder is :\n");
		inOrder(node);
	}

	private static void extracted() {
		String[] parent = { "2", "1", "3", "null", "4", "null", "7" };

		extracted(parent);
		String[] parent1 = { "1", "3", "2", "5" };
		System.out.println("\n\n\n");
		extracted(parent1);

		
		String[] parent2 = { "1", "2", "3", "4", "5", "6", "7" };
		System.out.println("\n\n\n");
		extracted(parent2);
	}

	private static void extracted(String[] parent) {
		Node root = createTree(parent, 0);
		System.out.println("Node print");
		root.print();
		System.out.println();
		System.out.println();
		System.out.println("Node inOrder");
		inOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("Node preOrder");
		preOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("Node postOrder");
		postOrder(root);
	}

}

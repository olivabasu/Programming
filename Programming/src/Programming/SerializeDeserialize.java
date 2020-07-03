package Programming;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserialize 
	{
	private static void buildString(Tree root, StringBuilder sb) {
		if (root == null) 
			sb.append("null").append(",");
	    else {
	        sb.append(root.data).append(",");
	        buildString(root.left, sb);
	        buildString(root.right,sb);
	    }
	}
	//Serialize wrapper

		public static String serialize(Tree root) {
		    StringBuilder sb = new StringBuilder();
		    buildString(root, sb);
		    return sb.toString();
		}
		
	   
	private static Tree buildTree(List list) {
	    String s = (String) list.remove(0); //retrieve first in list
	    if (s.equals("null")) 
	    	return null;
	    else {
	        Tree node = new Tree(Integer.valueOf(s));
	        node.left = buildTree(list);
	        node.right = buildTree(list);
	        return node;
	    }
	}
	//Deserialize wrapper
	
		public static Tree deserialize(String data) {
			List list = new LinkedList<>();
		    list.addAll(Arrays.asList(data.split(",")));
		    return buildTree(list);
		}
 
    public static void main(String args[]) throws IOException 
    {

    	BinarySearchTree bst = new BinarySearchTree();
		bst.insert('a');
		bst.insert('c');
		bst.insert('b');
        System.out.println("Original BST ");
		bst.preOrder();
		System.out.println();
		
		Tree r = bst.root;		
	    String str1 = serialize(r);
		Tree root1 = deserialize(str1);
		System.out.println("BST after in-order:");
		bst.inorder(root1);	      
    }
}

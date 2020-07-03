package Programming;

import java.io.FileWriter;

public class BinarySearchTree 
{
	Tree root;
    public BinarySearchTree()
    {
        root = null;
    }
    // Function to insert data 
    public void insert(int data)
    {
        root = insert(root, data);
    }
    //Insertion
    private Tree insert(Tree node, int data)
    {
        if (node == null)
            node = new Tree(data);
        else
        {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    public void preOrder()
    {
        preOrder(root);
    }
    void preOrder(Tree r)
    {
        if (r != null)
        {
            System.out.print((char)r.data +" ");
            preOrder(r.left);             
            preOrder(r.right);
        }
    }
    // Function for postorder traversal 
    public void postorder()
    {
        postorder(root);
    }
     void postorder(Tree r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print((char)r.data +" ");
        }
    } 
    // Function for inorder traversal 
    public void inorder()
    {
        inorder(root);
    }
    void inorder(Tree r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print((char)r.data +" ");
            inorder(r.right);
        }
    }
}

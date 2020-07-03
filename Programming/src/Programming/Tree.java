package Programming;

public class Tree {
	
	protected int data;
	protected Tree left = null;        
	protected Tree right = null;
	
	//Default constructor
    public Tree() {}

    public Tree(int val, Tree n1, Tree n2) {      
        this.data = val;
        this.left = n1;
        this.right = n2;        
    }
   
    public Tree(int val) {      
    	this.data = val;       
    } 

    public String toString() {
    	return String.valueOf(data);
    }
}  
 

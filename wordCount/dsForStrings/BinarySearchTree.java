package wordCount.dsForStrings;

import wordCount.util.Logger;
import wordCount.visitors.VisitorI;


public class BinarySearchTree implements BSTintreface {	
	
	
	public Node root=null;

	
	String file_input;
	String file_output;
	

	
	public BinarySearchTree(String fileNameIN, String outputFileIN)
	{
		Logger.writeMessage("BinarySearchTree constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		file_input=fileNameIN;
		file_output = outputFileIN;
		
	}
	
	
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
	}


	public void accept(VisitorI visitor){
		
		visitor.visit(this);
		
	}
	
	
	public Node getRoot()
	{
		return root;
	}
	
	
	

	  public void insert(Node node){
	    
	    if ( root == null ) {
	      root = node;
	      return;
	    }

	    insertRec(root, node);

	  }

	  public void insertRec(Node latestRoot, Node node){

	    if (latestRoot.word.compareTo(node.word)>0){

	      if ( latestRoot.left == null ){
	        latestRoot.left = node;
	        return;
	      }
	      else{
	        insertRec(latestRoot.left, node);
	      }
	    }
	    else if(latestRoot.word.compareTo(node.word)<0){
	      if (latestRoot.right == null){
	        latestRoot.right = node;
	        return;
	      }
	      else{
	        insertRec(latestRoot.right, node);
	      }
	    }
	    else if(latestRoot.word.compareTo(node.word)==0)
	    {
	    	latestRoot.freq++;
	    }
	  }
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
	  
	  
	  
	  
	  /**
	   * Printing the contents of the tree in an inorder way.
	   */
	  public void printInorder(){
	    printInOrderRec(root);
	    System.out.println("");
	  }
	  	   

	  /**
	   * Helper method to recursively print the contents in an inorder way
	   */
	  public void printInOrderRec(Node currRoot){
	    if ( currRoot == null ){
	    	//System.out.println("nullll");
	      return;
	    }
	    printInOrderRec(currRoot.left);
	    System.out.print(currRoot.word+ " "+currRoot.freq+", ");
	    printInOrderRec(currRoot.right);
	  }
	  
	    
	  
	  
	  
	  
	  public void cloneNodes(BSTintreface backupTree){
		  
		  cloneNodesRec(root, backupTree);
		   
		  }
	  
	  
	  public void cloneNodesRec(Node temp, BSTintreface backupTree)
	  {
		  if (temp == null)
			  return;

	 
		  try {
			  	    Node temp1 = (Node)temp.clone();
			  		temp1.left=null;
			  		temp1.right=null;
			  		backupTree.insert(temp1);
			  		temp1.registerObserver(temp1, temp1.word);
			  					  		
		  		} catch (CloneNotSupportedException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}

		  cloneNodesRec(temp.left, backupTree);
	
		  cloneNodesRec(temp.right, backupTree);
 }

	  
	  

	
	
	public void cloneTree(BSTintreface backupTree)
	{		
		cloneNodes(backupTree);		
	}


	  
	  
	
}

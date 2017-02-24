package wordCount.dsForStrings;



import wordCount.visitors.VisitorI;

public interface BSTintreface {

	public Node getRoot();
	public void accept(VisitorI visitor);
	public void insert(Node node);
	public void insertRec(Node latestRoot, Node node);
	
	public void printInorder();
	public void printInOrderRec(Node currRoot);
	
	public void cloneNodes(BSTintreface backupTree);
	public void cloneNodesRec(Node temp, BSTintreface backupTree);
	
	public void cloneTree(BSTintreface backupTree);
	
}

package wordCount.visitors;

import wordCount.dsForStrings.BSTintreface;
import wordCount.util.Logger;


public class CloneVisitor implements VisitorI {
	
	BSTintreface backupTree;

	public CloneVisitor(BSTintreface backupTreeIN) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage("CloneVisitor constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		backupTree = backupTreeIN;
	}

	public void visit(BSTintreface bst) {
		// TODO Auto-generated method stub
		
		Logger.writeMessage("In visit method of CloneVisitor", Logger.DebugLevel.VISIT_METHOD);
		bst.cloneTree(backupTree);
		
		
	}

}

package wordCount.visitors;

import wordCount.dsForStrings.BSTintreface;
import wordCount.test.TreeTraversal;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

public class WordCountVisitor implements VisitorI {
	
	FileProcessor fp;
	
	public WordCountVisitor(FileProcessor fpIN)
	{
		Logger.writeMessage("WordCountVisitor constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		fp = fpIN;
		
	}

	public void visit(BSTintreface bst) {
		// TODO Auto-generated method stub
		
		Logger.writeMessage("In visit method of WordCountVisitor", Logger.DebugLevel.VISIT_METHOD);
		
		TreeTraversal t1 = new TreeTraversal();
		t1.countNodes(bst.getRoot());
		fp.writeToFile("Total words: "+ t1.countTotalWords() + "\nDistinct words: " + t1.countDistinctWords() + "\nTotal chars: " + t1.countchars() );
		
	}

}

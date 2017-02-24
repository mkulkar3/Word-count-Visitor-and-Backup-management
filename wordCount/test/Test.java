package wordCount.test;
import wordCount.dsForStrings.BSTintreface;
import wordCount.dsForStrings.Node;
import wordCount.util.Logger;


public class Test {

	BSTintreface bst;
	
	public Test(BSTintreface bstIN)
	{
		Logger.writeMessage("Test constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		bst = bstIN;
	}
	
	public void updateTree()
	{
		updatenodes("updated-");
	}

	
	
	
	
	public void updatenodes(String newWord) {
		
		updateNodesRec(bst.getRoot(), newWord);
				
	}
	
	
	
	
	public void updateNodesRec(Node currRoot,String newWord){
		if ( currRoot == null ){
			return;
		}
		    
		updateNodesRec(currRoot.left, newWord);
		String oldWord = currRoot.word;
		currRoot.word = newWord + currRoot.word;
		currRoot.notifyObservers(oldWord, currRoot.word);
		updateNodesRec(currRoot.right, newWord);
		  
	}
	
	
	
	
}

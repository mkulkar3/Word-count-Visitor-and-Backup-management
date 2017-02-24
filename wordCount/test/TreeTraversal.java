package wordCount.test;
import wordCount.util.Logger;
import wordCount.dsForStrings.Node;


public class TreeTraversal {

	int wrdCnt, totalWords, chars;
	
	public TreeTraversal()
	{
		Logger.writeMessage("TreeTraversal constructor called....", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	 public int countNodes(Node root)
	  {		 
	  		countNodesRec(root);
			//System.out.println(chars+"-"+totalWords);
		    return wrdCnt;
	  }
	  
	  
	  public void countNodesRec(Node currRoot)
	  {
		  if ( currRoot == null ){
		      return;
		    }
		  countNodesRec(currRoot.left);
		  wrdCnt++;
		  totalWords += currRoot.freq;
		  chars += currRoot.word.length() * currRoot.freq;
		  countNodesRec(currRoot.right);
	  }
	
	  
	  
	  public int countTotalWords() {
			// TODO Auto-generated method stub
			return totalWords;
		}

		public int countchars() {
			// TODO Auto-generated method stub
			return chars;
		}
		

		public int countDistinctWords()
		{
			//int numOfWords = countNodes();
			//System.out.println("Total Distinct Words: "+numOfWords);
			//fp.writeToFile("Total Distinct Words: "+numOfWords);
			
			
			return wrdCnt;
			
		}
	  
	  
	
	
}

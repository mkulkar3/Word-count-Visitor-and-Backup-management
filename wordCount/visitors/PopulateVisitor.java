package wordCount.visitors;
//import java.io.IOException;
import java.util.StringTokenizer;

import wordCount.dsForStrings.BSTintreface;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;


public class PopulateVisitor implements VisitorI {
	
	FileProcessor fp;
	
	public PopulateVisitor(FileProcessor fpIN)
	{
		Logger.writeMessage("In visit method of PopulateVisitor", Logger.DebugLevel.VISIT_METHOD);
		fp = fpIN;
	}
	

	public void visit(BSTintreface bst) {
		// TODO Auto-generated method stub
		
		
		String line="";
		while((line=fp.readOneLine())!= null)
		{
			
			StringTokenizer defaultTokenizer = new StringTokenizer(line);
			while(defaultTokenizer.hasMoreTokens())
			{
				String temp = defaultTokenizer.nextToken();
				Node node = new Node(temp);
				bst.insert(node);
			}
			
		}
		
		
		
		
		
		
		
	}

}

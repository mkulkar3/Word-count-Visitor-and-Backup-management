package wordCount.driver;
import wordCount.util.Logger;
import wordCount.dsForStrings.BSTintreface;
import wordCount.dsForStrings.BinarySearchTree;
import wordCount.test.Test;
import wordCount.util.FileProcessor;
import wordCount.visitors.CloneVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.VisitorI;
import wordCount.visitors.WordCountVisitor;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 5)
		{
			System.out.println("Invalid number of arguments...");
			System.exit(0);
		}
		
		
		
		String fileINname = args[0];
		String fileOUTname = args[1];
		String originalTreeFile = args[2];
		String bckupTreeFile = args[3];
		
		int debug_value = Integer.parseInt(args[4]);
		
		if(debug_value > 4 || debug_value < 0)
		{
			System.out.println("Debug value should be between 0 to 4...");
		}
		
		Logger.setDebugValue(debug_value);
		
		BSTintreface bst=null;
		BSTintreface backupTree=null;
		
		double startTime = System.currentTimeMillis();
		
		for(int i=0; i<10; i++)
		{		
		
			FileProcessor fp = new FileProcessor(fileINname, fileOUTname);
			backupTree = new BinarySearchTree();
			bst = new BinarySearchTree(fileINname, fileOUTname);	
		
			VisitorI populate = new PopulateVisitor(fp);
			bst.accept(populate);
		
			VisitorI wrdCnt = new WordCountVisitor(fp);
			bst.accept(wrdCnt);
			fp.closeFile();
		
		}
		
		double finishTime = System.currentTimeMillis();
		double total_time = (finishTime-startTime)/100;
		
		System.out.println(total_time+ " milli secs");
		
		VisitorI CloneBst = new CloneVisitor(backupTree);		
		bst.accept(CloneBst);
		
		FileProcessor fp = new FileProcessor(originalTreeFile, bckupTreeFile, 1);
		
		fp.printOriginalTreeToFile(bst);
		
		//bst.printInorder();
		
		
		
		Test t1 = new Test(bst);		
		t1.updateTree();		
		
		fp.printBckupTreeToFile(backupTree);
		
		fp.closeFile1();
		//backupTree.printInorder();
		
	}

}

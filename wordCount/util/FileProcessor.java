package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.dsForStrings.BSTintreface;
import wordCount.dsForStrings.Node;

//import registrationScheduler.util.Logger;


public class FileProcessor {

	
	String inputFileName, outputFileName, originalTreeFile, bckupTreeFile;
	BufferedReader br;
	BufferedWriter bw;
	BufferedWriter bw1;
	BufferedWriter bw2;
	

	
	public FileProcessor(String file_IN, String file_OUT) {
		
		Logger.writeMessage("File_Processor constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		inputFileName = file_IN;
		outputFileName = file_OUT;
		
		 
		try {
			br = new BufferedReader(new FileReader(inputFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bw = new BufferedWriter(new FileWriter(outputFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public FileProcessor(String originalIN, String bckupIN, int flag)
	{
		originalTreeFile = originalIN;
		bckupTreeFile = bckupIN;
		
		try {
			bw1 = new BufferedWriter(new FileWriter(originalTreeFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			bw2 = new BufferedWriter(new FileWriter(bckupTreeFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public void closeFile()
	{
		try {
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void closeFile1()
	{
		try {
			bw1.close();
			bw2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String readOneLine()
	{
		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
	

	public void writeToFile(String toWrite)
	{
		try {
			bw.write("\n"+toWrite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void printOriginalTreeToFile(BSTintreface tree)
	{
		printOriginalTreeRecc(tree.getRoot());
	}
	
	public void printOriginalTreeRecc(Node currRoot)
	{
		if ( currRoot == null ){
	    	//System.out.println("nullll");
	      return;
	    }
		printOriginalTreeRecc(currRoot.left);
	    try {
			bw1.write(currRoot.word+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    printOriginalTreeRecc(currRoot.right);
		
	}
	
	
	
	public void printBckupTreeToFile(BSTintreface tree)
	{
		printBckupTreeRecc(tree.getRoot());
	}
	
	public void printBckupTreeRecc(Node currRoot)
	{
		if ( currRoot == null ){
	    	//System.out.println("nullll");
	      return;
	    }
		printBckupTreeRecc(currRoot.left);
	    try {
			bw2.write(currRoot.word+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    printBckupTreeRecc(currRoot.right);
		
	}
	
	
	
	
	


	
}

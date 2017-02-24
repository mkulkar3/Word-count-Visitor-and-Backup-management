
package wordCount.dsForStrings;
import java.util.HashMap;

import wordCount.util.Logger;



public class Node implements Cloneable, Subject, Observer{
	
    HashMap<String, Observer> Hmap = new HashMap<String, Observer>(); 
	
	
	public String word;
	public int freq;
	
	public Node left;
	public Node right;

	public Node(String wordIN) {
		Logger.writeMessage("Node constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		freq = 1;
	    word = wordIN;	    
	}

	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	public void update(String newWord) {
		// TODO Auto-generated method stub
		word = newWord;
		Logger.writeMessage("Observer updated", Logger.DebugLevel.OBSERVER_UPDATED);
		//toUpdate.word = newValue;
		
	}

	public void registerObserver(Observer o, String key) {
		// TODO Auto-generated method stub
		
		Hmap.put(key, o);
		
		
	}

	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void notifyObservers(String key, String newkey) {
		// TODO Auto-generated method stub
	
		Observer oldObserver = Hmap.get(key);
		oldObserver.update(newkey);
		
	}
}

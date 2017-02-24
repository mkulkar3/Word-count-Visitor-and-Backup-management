package wordCount.dsForStrings;

public interface Subject {

	public void registerObserver(Observer o, String key);
	public void removeObserver(Observer o);
	public void notifyObservers(String key, String new1);
	
}

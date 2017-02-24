package wordCount.util;

//import wordCount.util.Logger.DebugLevel;

public class Logger {
	

    public static enum DebugLevel {NONE, CONTENTS_TREE, OBSERVER_UPDATED, VISIT_METHOD, CONSTRUCTOR
                               		};

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
		case 0: debugLevel = DebugLevel.NONE; break;
		case 1: debugLevel = DebugLevel.CONTENTS_TREE; break;
		case 2: debugLevel = DebugLevel.OBSERVER_UPDATED; break;
		case 3: debugLevel = DebugLevel.VISIT_METHOD; break;
	  	case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String message, DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }

}

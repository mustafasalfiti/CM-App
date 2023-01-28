package application;

import dbadapter.*;

public class CMApp {

    private static CMApp instance;

    /**
     * Implementation of the Singleton pattern.
     * 
     * @return
     */
    public static CMApp getInstance() {
        if (instance == null) {
            instance = new CMApp();
        }
        return instance;
    }
}
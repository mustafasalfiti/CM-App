package application;

import java.util.ArrayList;

import dbadapter.*;
import interfaces.*;

public class CMApp implements KCmds {

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

    /**
     * create a user and saved in the database
     * 
     * @return
     */
    @Override
    public Boolean register(Kunde kunde) {
        try {
            return DBFacade.getInstance().createUser(kunde);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ArrayList<Presentation> showPresentations() {
        try {
            return DBFacade.getInstance().getPresentations();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Presentation>();
        }

    }

    /**
     * Initiates deactivating of all presentations that started.
     */
    public void deactivatePresentation() {
    }
}
package interfaces;

import java.util.ArrayList;

import dbadapter.Presentation;

public interface IPresentation {

    /*
     * deactivate presentation set isArchive true;
     */
    public boolean deactivatePresentation();

    /*
     * get all presentations
     */
    public ArrayList<Presentation> getPresentations();

    /**
     * create a new presentation
     * 
     * @Param presentation
     */
    public boolean setPresentation(Presentation presentation);
}

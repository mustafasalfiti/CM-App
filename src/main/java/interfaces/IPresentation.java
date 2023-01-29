package interfaces;

import java.util.ArrayList;

import dbadapter.Presentation;

public interface IPresentation {
    public boolean deactivatePresentation();

    public ArrayList<Presentation> getPresentations();

    public boolean setPresentation();
}

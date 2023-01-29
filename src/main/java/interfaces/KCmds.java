package interfaces;

import java.util.ArrayList;

import dbadapter.Kunde;
import dbadapter.Presentation;

public interface KCmds {

    public Boolean register(Kunde kunde);

    public ArrayList<Presentation> showPresentations();

}

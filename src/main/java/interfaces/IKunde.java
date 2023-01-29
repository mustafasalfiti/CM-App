package interfaces;

import dbadapter.Kunde;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 * @author Mustafa Alsalfiti
 *
 */
public interface IKunde {
    public boolean createUser(Kunde kunde);

    public boolean isEmailUnique(String email);
}

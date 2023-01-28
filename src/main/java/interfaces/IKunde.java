package interfaces;

import dbadapter.Kunde;

public interface IKunde {
    public boolean createUser(Kunde kunde);

    public boolean isEmailUnique(String email);
}

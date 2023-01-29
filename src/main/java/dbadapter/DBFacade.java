package dbadapter;

import java.sql.*;
import java.util.ArrayList;

import interfaces.IKunde;
import interfaces.IPresentation;

/**
 * Class which acts as the connector between application and database. Creates
 * Java objects from SQL returns. Exceptions thrown in this class will be
 * catched with a 500 error page.
 * 
 */
public class DBFacade implements IKunde, IPresentation {
    private static DBFacade instance;

    /**
     * Constructor which loads the corresponding driver for the chosen database type
     */
    private DBFacade() {
        try {
            Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementation of the Singleton pattern.
     * 
     * @return
     */
    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }

        return instance;
    }

    public static void setInstance(DBFacade dbfacade) {
        instance = dbfacade;
    }

    /**
     * create user
     * 
     * @param Kunde create a user with these credentials
     * @return true if created false if not
     */

    @Override
    public boolean createUser(Kunde kunde) {
        if (!this.isEmailUnique(kunde.getEmail())) {
            return false;
        }

        // query data.
        try {
            String sql = "INSERT INTO Kunde (name, email, password) VALUES (?,?,?)";
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                    + Configuration.getPort() + "/" + Configuration.getDatabase()
                                    + "?serverTimezone=UTC",
                            Configuration.getUser(), Configuration.getPassword());
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kunde.getName());
            stmt.setString(2, kunde.getEmail());
            stmt.setString(3, kunde.getPassword());
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * check if email is unique
     * 
     * @return
     */
    @Override
    public boolean isEmailUnique(String email) {
        boolean isUnique = true;
        try {
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                    + Configuration.getPort() + "/" + Configuration.getDatabase()
                                    + "?serverTimezone=UTC",
                            Configuration.getUser(), Configuration.getPassword());
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Kunde WHERE email = '" + email + "'");

            // Check the number of returned rows
            if (rs.next()) {
                isUnique = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUnique;
    }

    /**
     * get required presentations
     * 
     * @return a list of presentation
     */

    @Override
    public ArrayList<Presentation> getPresentations() {
        ArrayList<Presentation> result = new ArrayList<Presentation>();

        // query data.
        try {
            String sql = "SELECT * FROM films WHERE startTime > CURRENT_TIMESTAMP";
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                    + Configuration.getPort() + "/" + Configuration.getDatabase()
                                    + "?serverTimezone=UTC",
                            Configuration.getUser(), Configuration.getPassword());
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // don't show archived presentation
                if (rs.getBoolean("isArchived") == false) {
                    Presentation presentation = new Presentation();
                    presentation.setDauer(rs.getInt("dauer"));
                    presentation.setHall(rs.getInt("hall"));
                    presentation.setId(rs.getInt("id"));
                    presentation.setStartTime(rs.getTimestamp("starttime"));
                    presentation.setEndTime(rs.getTimestamp("endtime"));
                    presentation.setIsArchived(false);
                    result.add(presentation);

                }

            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    /**
     * Archive a Presnetation
     * 
     * @return
     */
    @Override
    public boolean deactivatePresentation() {
        return false;
    }

    /**
     * Archive a Presnetation
     * 
     * @return
     */
    @Override
    public boolean setPresentation() {
        // TODO Auto-generated method stub
        return false;
    }
}
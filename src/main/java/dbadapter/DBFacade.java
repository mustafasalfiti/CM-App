package dbadapter;

import java.sql.*;

import interfaces.IKunde;

public class DBFacade implements IKunde {
    private static DBFacade instance;

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

    @Override
    public boolean createUser(Kunde kunde) {
        if (!this.isEmailUnique(kunde.getEmail())) {
            return false;
        }

        // query data.
        try {
            String sql = "INSERT INTO Kunde (name, password, email) VALUES (?,?,?)";
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                    + Configuration.getPort() + "/" + Configuration.getDatabase(),
                            Configuration.getUser(), Configuration.getPassword());
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kunde.getName());
            stmt.setString(2, kunde.getEmail());
            stmt.setString(3, kunde.getPassword());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isEmailUnique(String email) {
        boolean isUnique = true;

        try {
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                    + Configuration.getPort() + "/" + Configuration.getDatabase(),
                            Configuration.getUser(), Configuration.getPassword());
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Kunde WHERE email = '" + email + "'");

            // Check the number of returned rows
            if (rs.next()) {
                isUnique = false;
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUnique;
    }
}
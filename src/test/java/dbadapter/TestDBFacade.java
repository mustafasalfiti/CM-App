package dbadapter;

// used jupiter api to test this is why there is no need to use TestCase
import org.junit.jupiter.api.Test;
import java.sql.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestDBFacade {
    private static Kunde kundeDB;
    private static Presentation preDB;

    @BeforeAll
    public static void setUp() {
        kundeDB = new Kunde("Mustafa", "Mustafa@email", "Password");

    }

    @Test
    public void testCreateUser() {
        Boolean result = null;
        result = DBFacade.getInstance().createUser(kundeDB);
        assertTrue(result == true);
        // test duplicate if false means user didn't created
        result = DBFacade.getInstance().createUser(kundeDB);
        assertTrue(result == false);

    }

    @AfterAll
    public static void tearDown() {
        // Declare SQL query to insert offer.
        // this query delete all the data in the Kunde table without remove table
        String sql = "TRUNCATE TABLE Kunde";

        // Insert offer into database.
        try {
            // remove all users from database
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                    + Configuration.getPort() + "/" + Configuration.getDatabase()
                                    + "?serverTimezone=UTC",
                            Configuration.getUser(), Configuration.getPassword());
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Number of rows deleted: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

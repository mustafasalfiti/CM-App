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
        preDB = new Presentation();
        preDB.setDauer(2);
        preDB.setTitle("X-Ray");
        preDB.setHall(35);
        preDB.setId(1);
        // add extra time to the starttime so that we can get startTime >
        // CURRENT_TIMESTAMP
        preDB.setStartTime(new Timestamp(System.currentTimeMillis() + 10000000));
        preDB.setEndTime(new Timestamp(System.currentTimeMillis()));
        preDB.setIsArchived(false);

        kundeDB = new Kunde("Mustafa", "Mustafa@email", "Password");

        // create a new Presentation in databank for test purposes
        DBFacade.getInstance().setPresentation(preDB);

    }

    @Test
    public void testCreateUser() {
        // check if create user works
        assertTrue(DBFacade.getInstance().createUser(kundeDB) == true);
        // check if we can sign in with the same email again
        assertTrue(DBFacade.getInstance().createUser(kundeDB) == false);
    }

    @Test
    public void getPresentations() {
        assertEquals(DBFacade.getInstance().getPresentations().size(), 1);
    }

    @AfterAll
    public static void tearDown() {
        // Declare SQL query to insert offer.
        // this query delete all the data in the Kunde table without remove table
        String sql = "TRUNCATE TABLE Kunde";
        String sql1 = "TRUNCATE TABLE Presentation";

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
            int result1 = stmt.executeUpdate(sql1);
            System.out.println("Number of rows deleted in Kunde: " + result);
            System.out.println("Number of rows deleted: in Presentation" + result1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

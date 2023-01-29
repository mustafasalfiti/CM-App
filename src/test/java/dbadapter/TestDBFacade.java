package dbadapter;

// used jupiter api to test this is why there is no need to use TestCase
import org.junit.jupiter.api.Test;

import freemarker.ext.beans.TemplateAccessible;

import java.sql.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestDBFacade {
    private static Kunde kundeDB;
    private static Presentation preDB;

    @BeforeAll
    public static void setUp() {
        Presentation presentation = new Presentation();
        presentation.setDauer(2);
        presentation.setTitle("X-Ray");
        presentation.setHall(35);
        presentation.setId(1);
        presentation.setStartTime(new Timestamp(System.currentTimeMillis()));
        presentation.setEndTime(new Timestamp(System.currentTimeMillis()));
        presentation.setIsArchived(false);

        kundeDB = new Kunde("Mustafa", "Mustafa@email", "Password");

        // create a new presentation in databank for test purposes
        DBFacade.getInstance().setPresentation(presentation);

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

    @Test
    public void getPresentations() {
        ArrayList<Presentation> result;
        result = DBFacade.getInstance().getPresentations();
        result[0].getTitle();
        assertEquals(result.size(), 1);

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
            System.out.println("Number of rows deleted: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

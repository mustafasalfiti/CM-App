package servlets;

// used jupiter api to test this is why there is no need to use TestCase
import org.junit.jupiter.api.Test;

import net.sourceforge.jwebunit.WebTester;
import org.junit.jupiter.api.BeforeAll;

public class RegisterServletTest {
    private static WebTester tester;

    /*
     * Prepare the tester before test
     */
    @BeforeAll
    public static void prepare() {
        tester = new WebTester();
    }

    @Test
    public static void testRegister() {
        tester.beginAt("/register.ftl");
        tester.assertTextPresent("Register");
        tester.assertTextPresent("When you register you will be able to book tickets for your best show!");
        tester.assertSubmitButtonPresent("Submit");

        // set fields

        tester.submit("Submit");

        tester.assertTextPresent("Success");
    }
}

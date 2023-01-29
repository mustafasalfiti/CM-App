package servlets;

// used jupiter api to test this is why there is no need to use TestCase
import org.junit.jupiter.api.Test;

import net.sourceforge.jwebunit.WebTester;

import org.junit.jupiter.api.BeforeAll;

public class PresentationServletTest {
    private static WebTester tester;

    /*
     * Prepare the tester before test
     */
    @BeforeAll
    public static void prepare() {
        tester = new WebTester();
        // tester.setBaseUrl("http://localhost:8080/project/presentation");

    }

    @Test
    public static void testRegister() {
        tester.beginAt("/presentation.ftl");
        // there is no presentations to show only one text
        tester.assertTextPresent("Choose a presentation");
    }
}

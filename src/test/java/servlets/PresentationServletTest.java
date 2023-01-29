package java.servlets;

public class PresentationServletTest {
    private WebTester tester;

    /*
     * Prepare the tester before test
     */
    @Before
    public void prepare() {
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080/project/presentation");
    }

    @Test
    public void testRegister() {
        // there is no presentations to show only one text
        tester.assertTextPresent("Choose a presentation");
    }
}

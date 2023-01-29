package java.servlets;

public class RegisterServletTest {
    private WebTester tester;

    /*
     * Prepare the tester before test
     */
    @Before
    public void prepare() {
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080/project/register");
    }

    @Test
    public void testRegister() {
        tester.assertTextPresent("Register");
        tester.assertTextPresent("When you register you will be able to book tickets for your best show!");
        test.assertSubmitButtonPresent("Submit");

        // set fields

        texter.setTextField("name", "Mustafa");
        texter.setTextField("email", "t@t");
        texter.setTextField("password", "testtttt");
        tester.submit("Submit");

        tester.assertTextPresent("Success");
    }
}

package servlets;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import application.CMApp;
import dbadapter.Kunde;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            System.out.println("DONE");
            req.getRequestDispatcher("/templates/register.ftl").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        Boolean result = null;
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            result = CMApp.getInstance().register(new Kunde(name, email, password));

            if (result == true) {
                req.setAttribute("done", true);
                req.getRequestDispatcher("/templates/Register_success.ftl").forward(req, res);

            } else {
                req.getRequestDispatcher("/templates/Register_error.ftl").forward(req, res);

            }

            // not yet implemented
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

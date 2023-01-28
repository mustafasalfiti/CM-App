package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            System.out.println(name + password + email);
            req.getRequestDispatcher("/templates/register.ftl").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            // not yet implemented
            req.getRequestDispatcher("/templates/welcome.ftl").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

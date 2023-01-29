package servlets;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import application.CMApp;

@WebServlet(name = "PresentationServlet", urlPatterns = { "/presentations" })
public class PresentationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            req.setAttribute("presentations", CMApp.getInstance().showPresentations());
            req.getRequestDispatcher("/templates/presentation.ftl").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("not implemented");
    }
}

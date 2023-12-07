package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static by.itclass.constans.ApplicationConstants.LOGOUT_CONTROLLER;
import static by.itclass.constans.JspConstants.LOGIN_JSP;

@WebServlet(name = "logoutController", urlPatterns = LOGOUT_CONTROLLER)
public class LogoutController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // удалять объект session
        HttpSession session = req.getSession();
        session.invalidate();
        redirect(resp,LOGIN_JSP);

    }
}

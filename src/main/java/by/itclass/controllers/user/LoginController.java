package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

import static by.itclass.constans.ApplicationConstants.LOGIN_CONTROLLER;
import static by.itclass.constans.ApplicationConstants.USER_NOT_FOUND;
import static by.itclass.constans.JspConstants.*;

@WebServlet(name = "loginController", urlPatterns = LOGIN_CONTROLLER)
public class LoginController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASS_PARAM);

        User user = userService.getUser(login, password);
        if (!Objects.isNull(user)) { //если есть такой user
            HttpSession session = req.getSession();
            session.setAttribute(USER_ATTR, user);  //сохранили usera
            forward(req, resp, HOME_JSP);
        } else { //если нет такого user  то перенаправляем в начало введите логин и дадим сообщение
            forward(req, resp, LOGIN_JSP, USER_NOT_FOUND);
        }
    }
}

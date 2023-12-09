package by.itclass.controllers.user;

import by.itclass.constans.ApplicationConstants;
import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constans.ApplicationConstants.USER_NOT_REGISTRERED;
import static by.itclass.constans.JspConstants.*;

@WebServlet(urlPatterns = ApplicationConstants.REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // берем параметры из запроса - это и цель любого сервлета
        String login = req.getParameter(LOGIN_PARAM);
        String name = req.getParameter(NAME_PARAM);
        String password = req.getParameter(PASS_PARAM);
        String email = req.getParameter(EMAIL_PARAM);

        // создаем user используя конструктор @RequiredArgsConstructor (login,name,email)
        User user = new User(login, name, email);
        // затем  вызываем метод из service, который получит два параметра
//  и вернет boolean
// внутри него есть метод который создаст dao
        if (userService.addUser(user, password)) {// вернет boolean
            redirect(resp, LOGIN_JSP); // если да- перекинем его на строничку login
            // что бы он смог зарегистрироваться
        } else {
            myForward(req, resp, REGISTRATION_JSP, USER_NOT_REGISTRERED); //если нет
            // перенаправим на страничку регистрации и дадим сообщение
        }


        //http://localhost:8080/jsp/registration.jsp
    }
}

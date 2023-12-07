package by.itclass.controllers;

import by.itclass.model.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.itclass.constans.JspConstants.MESSAGE_ATTR;

@WebServlet(name = "abstractController") // нет urlpattern
public abstract class AbstractController extends HttpServlet {
    protected UserService userService;

    @Override
    public void init() throws ServletException {
        // проверит есть ли service если нет создаст
        // чтобы не создавать еще одного
       userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    // методы которые будут делать формы String url - получит из переопределенного  метода myForward
    public void myForward(HttpServletRequest req, HttpServletResponse resp,
                          String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req,resp);     // url - адрес
 // getRequestDispatcher - создаст объект, который позволяет передавать информацию
// от одного сервлета к другому посредством вызовов метода.
// forward  - перенаправляет запрос из сервлета
 // на другой сервлет в пределах 1 запроса
    }

   // получит атрибут для метода myForward (String url)
    public void myForward(HttpServletRequest req, HttpServletResponse resp,
                          String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR,message);
        // setAttribute - закинет наш message  в аттрибуты
        myForward(req, resp, url); // url - адрес
        // перенаправит запрос
    }

    public void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

}

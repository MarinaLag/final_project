package by.itclass.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.itclass.constans.JspConstants.MESSAGE_ATTR;

@WebServlet(name = "abstractController") // нет urlpattern
public abstract class AbstractController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    // методы которые будут делать формы
    public void forward(HttpServletRequest req, HttpServletResponse resp,
                        String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req,resp);     // url - адрес
        // getRequestDispatcher - создаст объект, который позволяет передавать информацию
        // от одного сервлета к другому посредством вызовов метода.
        // forward  - перенаправляет запрос из сервлета
        // на другой сервлет в пределах 1 запроса
    }
   //
    public void forward(HttpServletRequest req, HttpServletResponse resp,
                        String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR,message);
        // setAttribute - закинет наш message  в аттрибуты
        forward(req, resp, url); // url - адрес
        // перенаправит запрос
    }

}

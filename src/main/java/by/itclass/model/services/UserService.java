package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.entities.User;

import java.util.Objects;

public class UserService {
    // service взависимости от параметра вызовет необходимый метод в dao
    // service и dao должно что-то соединять (поля)
    private static UserService service;
    private UserDao dao;

    // проверит есть ли dao , если нет создаст
    // конструктор ???
    private UserService() {
        dao = UserDao.getInstance();
    }

   // проверит есть ли service если нет создаст
    // чтобы не создавать еще одного
    public static UserService getInstance(){
        return Objects.isNull(service) ? new UserService() : service;
    }

    // вернет user. Пойдет в класс UserDao там реализует метод
    public User getUser(String login, String password) {
        return dao.getUser(login,password);
    }
    // добавит user. Пойдет в класс UserDao там реализует метод
    public boolean addUser(User user, String password) { //пароль не храниться в классе User
        return dao.addUser(user,password);
    }

}

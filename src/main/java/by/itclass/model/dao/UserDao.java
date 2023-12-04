package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.util.Objects;

public class UserDao {
    private static UserDao dao;

    private UserDao() {
        ConnectionManager.init();
// чтобы сработал dao вызываем метод в котором сработает два метода
// получен Connection
    }

    public static UserDao getInstance() {
        // если есть вернет объект dao, если нет - создаст dao
        return Objects.isNull(dao) ? new UserDao() : dao;
    }
// проверит есть ли user стаким логином и паролем
    public User getUser(String login, String password) {
        return null;
    }

    // проверить добавился ли  user
    public boolean addUser(User user, String password) { //пароль не храниться в классе User
        return false; // пока true - а надо false
    }
}

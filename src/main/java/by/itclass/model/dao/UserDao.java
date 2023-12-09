package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

import static by.itclass.constans.DbConstants.*;

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

    // проверит есть ли user с таким логином и паролем в БД
// и вернет одного пользователя
    public User getUser(String login, String password) {

        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_USER)) {
            ps.setString(1, login); //setString - т.к login (String)
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // один
                int id = rs.getInt(ID_COL); // можем передавать номер столбца
                String name = rs.getString(NAME_COL);
                String email = rs.getString(EMAIL_COL);
                return new User(id, login, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // проверить добавился ли в БД
    public boolean addUser(User user, String password) { //пароль не храниться в классе User
        try (Connection cn = ConnectionManager.getConnection();
             // запрос создан в DbConstants, где опишем какие поля вставляем в БД
             PreparedStatement ps = cn.prepareStatement(INSERT_USER);) {
            if (isAccessible(user.getLogin(), cn)) {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
                ps.setString(4, password);
                // если было добавление то будет выполнена 1 операция
                // а если у нас 1 , значит все хорошо
                return ps.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //проверяем не занят ли логин в БД
    private boolean isAccessible(String login, Connection cn) {
        // передаем cn чтобы не вызывать повторно
        // метод будет работать с копей login и cn
        try (PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_LOGIN)) {
            ps.setString(1, login);
            // если такого login нет - возвращает false - значит логин свободеен
            return !ps.executeQuery().next(); // false - значит логин свободеен
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // false - значит логин свободеен
    }
}

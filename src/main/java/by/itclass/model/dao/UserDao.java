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
    public User getUser(String login, String password) {

        try(Connection cn = ConnectionManager.getConnection();
            PreparedStatement ps = cn.prepareStatement(SELECT_USER)) {
            ps.setString(1,login);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt(ID_COL);
                String name = rs.getString(NAME_COL);
                String email = rs.getString(EMAIL_COL);
                return new User(id,login,name,email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // проверить добавился ли  user
    public boolean addUser(User user, String password) { //пароль не храниться в классе User
        return false; // пока true - а надо false
    }
}

package by.itclass.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;

public class ConnectionManager {
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String DB_FILE_PROPS = "db.properties";
// в данном файле храниться коллекцию типа properties
    // данные для подключения к драйверу и БД

    private static Connection cn;
    private static Properties props;

    // метод который проинициализирует наш класс, вместо конструктора
    public static void init (){
        loadProps(); // создаст Properties
        loadDriver();  // загрузим драйвер
    }

    private static void loadProps(){
        props = PropertiesManager.getProperties(DB_FILE_PROPS);
    }

    private static void loadDriver(){
        try {
            Class.forName(props.getProperty(DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // создание connection  и проверка есть ли
    public static Connection getConnection() throws SQLException {
        return Objects.isNull(cn) || cn.isClosed()
                ? DriverManager.getConnection(props.getProperty(URL), props)
                : cn;
// если это сn - возвращаем DriverManager.getConnection....
 // если нет cn
    }
}

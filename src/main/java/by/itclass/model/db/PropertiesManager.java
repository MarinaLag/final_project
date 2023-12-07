package by.itclass.model.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    // метод прочитает файл из ресурсов и сделает из него объект
    public static Properties getProperties(String filePath) {
        Properties props = new Properties(); // создаем пустышку
        try (FileReader fr = new FileReader(Thread.currentThread() // считываем
 // Thread - т.к. в другой директории!!!
// считываем Thread.currentThread() - возвращаем текущий наш поток
// раньше передовали путь к файлу, потомучто все находилось в одной директории
// сейчас наш файл находиться не в java а  resourses , это разные директории
                .getContextClassLoader().getResource(filePath).getPath())) {
// Thread - т.к. в другой директории!!!
 // getContextClassLoader - загружает наш класс и может достучаться до нашего файла
            props.load(fr); //создасться себя, т.е. объект properties и заполняется
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
 //  filePath - это наше поле  DB_FILE_PROPS
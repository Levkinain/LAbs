package ru.vsu.config;

import ru.vsu.sorter.Sorter;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * класс Configuration, реализует паттерн singleton, задает общую конфигурацию приложения
 */
public class Configuration {

    //статическое поле, которое описывает один из возможных ключей файла properties
    public static final String SORTER = "sorter";
    private static Configuration _instance = null;
    private Properties appProps = null;

    /**
     * Конструктор выполняющий создание экземпряра класса {@code Properties}
     */
    private Configuration() {
        //получаем путь к файлам ресурсов
        String rootPath = "D:/Labs-master/Lab1/src/main/resources/";
        // получаем путь к нашему ресурсу
        String appConfigPath = rootPath + "configuration.properties";
        //создаем экземпляр класса {@code Properties}, java.util.Properties
        appProps = new Properties();
        //выполним загрузку файла "properties.txt" в объект класса appProps
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (Exception e) {
            System.out.println("Не возможно загрузить ресурсы : " + e.getMessage());
        }
    }

    /**
     * метод необходимый для создания экземпляра класса {@code Configuration} реализующего паттерн Singleton
     *
     * @return {@code instance}
     * экземпляр класса {@code Configuration}
     */
    public synchronized static Configuration getInstance() {
        if (_instance == null)
            _instance = new Configuration();
        return _instance;
    }

    /**
     * Выполняет получение значения поля объекта типа {@code Properties} по ключу
     *
     * @param key ключ, по которому выполняется поиск свойства
     * @return объект value типа {@code String}, который содержит описание значения свойства, полученного по его ключу
     */
    public String getProperty(String key) {
        String value = null;
        if (appProps.containsKey(key))
            //здесь нужно допиливать
            value = (String) appProps.get(key);
        else {
            // сообщите о том, что свойство не найдено
        }
        return value;
    }

    /**
     *  Метод, возвращающий экземпляр класса, реализующий интерфейс sorter
     * @return sorter
     * экземпляр класса, реализующий интерфейс sorter
     */
    public Sorter getSorter() {
        Sorter sorter = null;
        try {
            //Спросить, как сделать, чтобы здесь не нужно было прописывать путь к пакету, в котором лежит наш класс
            String nameSorter ="ru.vsu.sorter.sorterImpl." + getProperty(SORTER);
            sorter = (Sorter) Class.forName(nameSorter).newInstance();
            return sorter;
        } catch (Exception e) {
           System.out.println("Сортер не найден" + e); ///Сделать здесь обработку исключений
        }
        return sorter;
    }
}



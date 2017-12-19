package ru.vsu.entity.entityImpl;

import org.joda.time.LocalDate;

/**
 * Person class.
 */
public class Person {
    //переменная для инкремментирвоания айдишника
    private static int tempId = 1;
    //
    private int id;
    //
    private String firstName;
    //
    private String middleName;
    //
    private String lastName;
    //
    private LocalDate birthday;

    /**
     * Конструктор выполняющий создание объекта типа {@code Person} с начально заданными данными имени.
     *
     * @param firstName  Имя
     * @param middleName Отчество
     * @param lastName   Фамилия
     */
    public Person(String firstName, String middleName, String lastName) {
        this.id = tempId;
        tempId++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Конструктор выполняющий создание объекта типа {@code Person} с начально заданными данными имени и даты рождения.
     *
     * @param firstName  Имя
     * @param middleName Отчество name
     * @param lastName   Фамилия
     * @param birthday   День рождения
     */
    public Person(String firstName, String middleName, String lastName, LocalDate birthday) {
        this.id = tempId;
        tempId++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
    /**Метод возвращающий уникальный идентификатор объекта типа {@code Person}
     * @return id
     * Уникальный идентификатор
     */
    public int getId() {
        return id;
    }

    /**Позволяет получить значение поля {@code firstName}
     * @return
     * Возвращает  имя представленное объектом типа {@code String}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Устанавливает значение поля {@code firstName}
     * @param firstName
     * имя представленное объектом типа {@code String}
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**Позволяет получить значение поля {@code middleName}
     * @return
     * Возвращает  отчество представленное объектом типа {@code String}
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Устанавливает значение поля {@code middleName}
     * @param middleName
     * отчество представленное объектом типа {@code String}
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**Позволяет получить значение поля {@code lastName}
     * @return
     * Возвращает  фамилию представленную объектом типа {@code String}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Устанавливает значение поля {@code lastName}
     * @param lastName
     * фамилия представленная объектом типа {@code String}
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**Позволяет получить возраст по дате рождения
     * @return
     * Возвращает  полное число лет представленную объектом типа {@code Integer}
     */
    public Integer getAge() {
        if (birthday == null) return 0;
        else return LocalDate.now().getYear() - birthday.getYear();
    }

    /**Позволяет получить значение поля {@code birthday}, которое хранит информацию о дне рождения
     * @return
     * Возвращает день рождения, представленный объектом типа {@code LocalDate}
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Переопределяет метод {@code toString}  класса родителя {@code Object},
     * выполняя преобразование объекта в его строковое предствление
     * @return
     * объект класса {@code String}, являющийся строковым представлением
     */
    @Override
    public String toString() {
        return Person.class.getSimpleName() +
                " id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", age=" + getAge() +
                '}';
    }
}

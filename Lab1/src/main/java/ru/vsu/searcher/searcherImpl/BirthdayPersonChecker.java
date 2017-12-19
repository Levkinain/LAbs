package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.Checker;

public class BirthdayPersonChecker implements Checker<Person>{

    /**Метод выполняющий проверку поля {@code LocalDate birthday} на соответствие значению  {@code Object value}
     * @param p
     * объект типа {@code Person}
     * @param value
     * Объект типа {@code Object } с которым сравнивается поле {@code LocalDate birthday}
     * @return
     * true, если значение поля {@code LocalDate birthday} соответствует значению {@code Object value}, в противном случае false
     */
    @Override
    public boolean check(Person p, Object value) {
        return p.getBirthday() != null && p.getBirthday().equals(value);
    }
}

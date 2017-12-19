package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.Checker;

public class LastNamePersonChecker implements Checker<Person> {

    /**Метод выполняющий проверку поля {@code String lastName} на соответствие значению  {@code Object value}
     * @param p
     * объект типа {@code Person}
     * @param value
     * Объект типа {@code Object } с которым сравнивается поле {@code String lastName}
     * @return
     * true, если значение поля {@code String lastName} соответствует значению {@code Object value}, в противном случае false
     */
    @Override
    public boolean check(Person p, Object value) {
        return p.getLastName().equals(value);
    }
}

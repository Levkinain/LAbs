package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.Checker;


public class IdPersonChecker implements Checker<Person> {

    /**Метод выполняющий проверку поля {@code int id} на соответствие значению  {@code Object value}
     * @param p
     * объект типа {@code Person}
     * @param value
     * Объект типа {@code Object } с которым сравнивается поле {@code int id}
     * @return
     * true, если значение поля {@code int id} соответствует значению {@code Object value}, в противном случае false
     */
    @Override
    public boolean check(Person p, Object value) {
        return Integer.valueOf(p.getId()).equals(value);//TODO: спросить, пойдет так или нет
    }
}

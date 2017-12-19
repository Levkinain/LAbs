package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Person;
import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    /** Сравнивает объекты типа {@code Person} по полю {@code  String lastName}
     * @param o1
     * Объект типа Person
     * @param o2
     * Объект типа Person
     * @return
     * 1 - если первый объект больше второго
     * 0 - равны
     * -1 - второй больше первого
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

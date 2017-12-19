package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Person;
import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

package ru.vsu.repository.repositoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import ru.vsu.comparator.comparatorImpl.*;
import ru.vsu.config.Configuration;
import ru.vsu.entity.entityImpl.Person;
import ru.vsu.repository.Repository;
import ru.vsu.repository.RepositoryAbstract;
import ru.vsu.searcher.Checker;
import ru.vsu.searcher.searcherImpl.LastNamePersonChecker;
import ru.vsu.sorter.Sorter;

public class PersonRepository extends RepositoryAbstract<Person> implements Repository<Person> {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());
    private static Sorter sorter = Configuration.getInstance().getSorter();
    /**
     * Конструктор по умолчанию, выполняющий создание объекта  типа {@code  PersonRepository} размера INITIAL_SIZE
     */
    public PersonRepository() {
        repository = new Person[INITIAL_SIZE];
        size = INITIAL_SIZE;
        capacity = 0;
    }

    /**
     * Метод выполняющий сортировку  {@code Person [] repository} по полю {@code int id}
     */
    public void sortById() {
        sorter.sort(repository, new PersonComparatorById());
    }

    /**
     * Метод выполняющий сортировку  {@code Person [] repository} по полю {@code int age}
     */
    public void sortByAge() {
        sorter.sort(repository, new PersonComparatorByAge());
    }

    /**
     * Метод выполняющий сортировку  {@code Person [] repository} по полю {@code String name}
     */
    public void sortByName() {
        sorter.sort(repository, new PersonComparatorByName());
    }



    private PersonRepository search(Checker<Person> checker, Object value) {
        PersonRepository result = new PersonRepository();
        for (int i = 0; i < repository.length; i++) {
            if (checker.check((Person) repository[i], value))
                result.add((Person) repository[i]);
        }
        return result;
    }

    /**
     * Метод выполняющий поиск по полю {@code lastName}
     *
     * @param lastName объект класса{@code String}, являющийся предекатом (выражением для поиска)
     * @return объект типа {@code PersonRepository}, содержащий объекты типа {@code Person}, у которых значение поля {@code lastName}
     * соответствует параметру поиска {@code String fio}
     */
    public PersonRepository searchByLastName(String lastName) {
        LOGGER.debug("This method was used");
        return search(new LastNamePersonChecker(), lastName);
    }

    /**
     * Метод выполняющий поиск по значению {@code Integer age}
     *
     * @param age значение типа {@code Integer}, являющееся предекатом (выражением для поиска)
     * @return объект типа {@code Repository}, содержащий объекты типа {@code Person}
     */
    public PersonRepository searchByAge(Integer age) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getAge().equals(a), age);
    }

    /**
     * Метод выполняющий поиск по значению {@code LocalDate date}
     *
     * @param date значение типа {@code LocalDate}, являющееся предекатом (выражением для поиска)
     * @return объект типа {@code Repository}, содержащий объекты типа {@code Person}
     */
    public PersonRepository searchByBirthDate(LocalDate date) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getBirthday() != null && p.getBirthday().equals(a), date);
    }

}

package ru.vsu.repository.repositoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vsu.comparator.comparatorImpl.CarComporatorById;
import ru.vsu.comparator.comparatorImpl.CarComporatorByPrice;
import ru.vsu.comparator.comparatorImpl.CarComporatorByYear;
import ru.vsu.config.Configuration;
import ru.vsu.entity.entityImpl.Car;
import ru.vsu.repository.Repository;
import ru.vsu.repository.RepositoryAbstract;
import ru.vsu.searcher.Checker;
import ru.vsu.sorter.Sorter;

import java.util.Comparator;

public class CarRepository extends RepositoryAbstract<Car> implements Repository<Car> {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());
    // объект типа {@code Sorter} который содержит способ сортировки(bubbleSort и т.д)
    private static Sorter sorter = Configuration.getInstance().getSorter();

    /**
     * Конструктор по умолчанию
     */
    public CarRepository() {
        repository = new Car[INITIAL_SIZE];
        size = INITIAL_SIZE;
        capacity = 0;
    }

    /**
     * Метод выполняющий сортировку  {@code Car [] repository} по полю {@code int id}
     */
    public void sortById() {
        Comparator<Car>  comporatorById = new CarComporatorById();
        sorter.sort(repository, comporatorById);
    }

    /**
     * Метод выполняющий сортировку  {@code Car [] repository} по полю {@code int price}
     */
    public void sortByPrice() {
        sorter.sort(repository, new CarComporatorByPrice());
    }
    /**
     * Метод выполняющий сортировку  {@code Car [] repository} по полю {@code int dateManufacture}
     */
    public void sortByYear() {
        sorter.sort(repository, new CarComporatorByYear());
    }

    /**
     * Метод выполняющий поиск в  {@code Car [] repository} по полю {@code int dateManufacture}
     */
    private CarRepository search(Checker<Car> checker, Object value) {
        CarRepository result = new CarRepository();
        for (int i = 0; i < repository.length; i++) {
            if (checker.check((Car) repository[i], value))
                result.add((Car) repository[i]);
        }
        return result;
    }

    /**
     * Метод выполняющий поиск по значению {@code String color}
     *
     * @param color значение типа {@code Integer}, являющееся предекатом (выражением для поиска)
     * @return объект типа {@code CarRepository}, содержащий объекты типа {@code Сar}
     */
    public CarRepository searchByColor(String color) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getColor().equals(a), color);
    }

    /**
     * Метод выполняющий поиск по значению {@code Integer price}
     *
     * @param price значение типа {@code Integer}, являющееся предекатом (выражением для поиска)
     * @return объект типа {@code CarRepository}, содержащий объекты типа {@code Сar}
     */
    public CarRepository searchByPrice(Integer price) {
        LOGGER.debug("This method was used");
        return search((p, a) -> Integer.valueOf(p.getPrice()).equals(a), price);
    }

    /**
     * Метод выполняющий поиск по значению {@code Integer year}
     *
     * @param year значение типа {@code Integer}, являющееся предекатом (выражением для поиска)
     * @return объект типа {@code CarRepository}, содержащий объекты типа {@code Сar}
     */
    public CarRepository searchByManufactureYear(Integer year) {
        LOGGER.debug("This method was used");
        return search((p, a) -> Integer.valueOf(p.getYearManufacture()).equals(a), year);
    }

}

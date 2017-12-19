package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Car;

import java.util.Comparator;

public class CarComporatorByYear implements Comparator<Car> {
    /**Сравнивает объекты типа {@code Car} по полю {@code  int yearManufacture}
     * @param o1
     * Объект типа Сar
     * @param o2
     * Объект типа Сar
     * @return
     * 1 - если первый объект больше второго
     * 0 - равны
     * -1 - второй больше первого
     */
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYearManufacture() - o2.getYearManufacture() < 0 ? -1 : (o1.getYearManufacture() == o2.getYearManufacture() ? 0 : 1);
    }
}

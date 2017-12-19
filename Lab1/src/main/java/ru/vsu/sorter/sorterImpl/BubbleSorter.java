package ru.vsu.sorter.sorterImpl;

import ru.vsu.sorter.Sorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс отвечающий за сортировку объектов методом пузырька
 */
public class BubbleSorter implements Sorter {
    /**
     * @param array
     * массив объектов, которые необходимо отсортировать
     * @param comparator
     * объект типа {@code Comparator}
     */
    @Override
    public void sort(Object[] array, Comparator comparator) {
        System.out.println(Arrays.toString(array));
        System.out.println(comparator.toString());
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    Object temp =  array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

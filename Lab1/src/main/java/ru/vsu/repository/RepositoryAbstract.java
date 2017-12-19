package ru.vsu.repository;

import ru.vsu.config.Configuration;
import ru.vsu.sorter.Sorter;

import java.util.Arrays;


public abstract class RepositoryAbstract<T> implements Repository<T> {

    protected static double EXTEND_COEFFICIENT = 1.2;
    protected static int INITIAL_SIZE = 1;
    protected Object[] repository;
    protected int size;//размер массива
    protected int capacity;//количество элементов в массиве

    /**Метод выполняющий получение объекта типа  {T[]) repository}
     * @return   {T[]) repository}
     * массив  элементов типа {@code T}
     */
    public T[] getRepository() {
        return (T[]) repository;
    }

    /** Метод выполняющий получение значения репозитория по индексу
     * @param index
     * индекс элемента, который нужно получить
     * @return  {@code (T repository[index])}
     *элемент репозитория типа {T}
     */
    @Override
    public T get(int index) {
        if (index < repository.length) {
            return (T) repository[index];
        } else {
            System.out.println("This index bigger than repository capacity");//
            return null;
        }
    }

    /**Метод выполняющий получение объекта типа  {T[]) repository}
     * @return   {T[]) repository}
     * массив  элементов типа {@code T}
     */
    @Override
    public T[] getArray() {
        return (T[]) repository;
    }

    @Override
    public void add(T t) {
        if (capacity + 1 > size) {
            extend();
        }
        repository[capacity] = t;
        capacity++;
        trimToSize();
    }

    /** Выполняет удаление элемента из репозитория по индексу
     * @param index
     * индекс удаляемого элемента
     */
    @Override
    public void remove(int index) {
        if (index < capacity) {
            System.arraycopy(repository, index + 1, repository, index, size - 1 - index);
            repository[size - 1] = null;
            capacity--;
            trimToSize();

        } else System.out.println("This index bigger than repository capacity");

    }

    /**Метод выполняющий получение числа  элементов репозитория
     * @return size
     * число  элеменов репозитория
     */
    public int getSize() {
        return size;
    }

    /**Метод выполняющий получение числа заполненных элементов репозитория
     * @return capacity
     * число заполненных элеменов репозитория
     */
    public int getCapacity() {
        return capacity;
    }

    protected void extend() {
        size = (int) (size * EXTEND_COEFFICIENT) + 1;
        repository = Arrays.copyOf(this.repository, size);
    }

    /**
     * Метод выполняющий сужение массива
     */
    protected void trimToSize() {
        this.repository = Arrays.copyOf(this.repository, capacity);
    }


}

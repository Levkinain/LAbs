package ru.vsu.repository;

public interface Repository<T> {

    // получение значения репозитория по индексу
    public T get(int index);
    // получение всего репозитория
    public T[] getArray();

    // добавление значения в репозиторий
    public void add(T t);

    // удаление значения из репозитория по индексу
    public void remove(int index);
}

package ru.vsu.entity.entityImpl;

public class Car {
    private static int tempId = 1;
    private int id;
    private String color;
    private int dateManufacture;
    private int price;
    private String model;


    /** Конструктор выполняющий создание объекта типа {@code Car} на основе сходных параметров
     * @param model
     * модель автомобиля
     * @param price
     * цена автомобиля
     * @param color
     * цвет автомобиля
     * @param dateManufacture
     */
    public Car(String model, int price, String color, int dateManufacture) {
        this.id = tempId;
        tempId++;
        this.model = model;
        this.price = price;
        this.color = color;
        this.dateManufacture = dateManufacture;
    }


    /**Позволяет получить значение поля {@code id}, которое хранит информацию о id автомобиля
     * @return
     * Возвращает id, представленный объектом типа {@code int}
     */
    public int getId() {
        return id;
    }

    /**Позволяет получить значение поля {@code color}, которое хранит информацию о цвете  автомобиля
     * @return
     * Возвращает color, представленный объектом типа {@code String}
     */
    public String getColor() {
        return color;
    }

    /**Позволяет получить значение поля {@code DateManufacture}, которое хранит информацию о годе производства  автомобиля
     * @return dateManufacture
     * Возвращает дату производства , представленную объектом типа {@code int}
     */
    public int getYearManufacture() {
        return dateManufacture;
    }

    /**Позволяет получить значение поля {@code price}, которое хранит информацию о цене  автомобиля
     * @return dateManufacture
     * Возвращает цену автомобиля , представленную объектом типа {@code int}
     */
    public int getPrice() {
        return price;
    }

    /**Позволяет получить значение поля {@code model}, которое хранит информацию о модели  автомобиля
     * @return dateManufacture
     * Возвращает модель автомобиля , представленную объектом типа {@code String}
     */
    public String getModel() {
        return model;
    }

    /**
     * Устанавливает значение поля {@code color}
     * @param color
     *  цвет автомобиля, представленный объектом типа {@code String}
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Устанавливает значение поля {@code price}
     * @param price
     *  цена автомобиля , представленная объектом типа {@code int}
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Переопределяет метод {@code toString}  класса родителя {@code Object},
     * выполняя преобразование объекта в его строковое предствление
     * @return
     * объект класса {@code String}, являющийся строковым представлением
     */
    @Override
    public String toString() {
        return Car.class.getSimpleName() +
                " id=" + id +
                ", color='" + color + '\'' +
                ", carDateManufacture=" + dateManufacture +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}

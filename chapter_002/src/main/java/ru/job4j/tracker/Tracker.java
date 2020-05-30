package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker implements ITracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам
     * нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Заменяет ячейку в массиве.
     * @param id ID искомой заявки
     * @param item заявка, которую необходимо вставить
     * @return должно вернуть true, при успешном завершении операции
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.get(i).setName(item.getName());
                result = true;
                item.setId(id);
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку
     * @param id - ID удаляемой заявки
     * @return true - если удаление выполнено
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок
     * @return Item[]
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод осуществляет поиск элементов, у которых совпадает имя с key
     * @param key Имя в искомой заявке
     * @return Item[]
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Получение заявки по ID
     * @param id ID заявки
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
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
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
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
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод осуществляет поиск элементов, у которых совпадает имя с key
     * @param key Имя в искомой заявке
     * @return Item[]
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                result[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Получение заявки по ID
     * @param id ID заявки
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

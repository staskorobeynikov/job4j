package ru.job4j.tracker;

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
        for (int i = 0; i != items.length; i++)
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
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
        if (items[position] != null && items[position].getId().equals(id)) {
            items[position] = null;
            result = true;
        }
        Item[] temp = new Item[items.length - 1];
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                System.arraycopy(items, i + 1, temp, i, items.length - i - 1);
                break;
            } else {
                temp[i] = items[i];
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок
     * @return Item[]
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод осуществляет поиск элементов, у которых совпадает имя с key
     * @param key Имя в искомой заявке
     * @return Item[]
     */
    public Item[] findByName(String key) {
        //Item[] result = new Item[0];
        int resultCount = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                resultCount++;
            }
        }
        int pos = 0;
        Item[] result = new Item[resultCount];
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[pos] = item;
                pos++;
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
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

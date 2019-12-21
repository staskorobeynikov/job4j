package ru.job4j.generic;

public class GeneralStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> store;

    public GeneralStore(int size) {
        store = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = findIndex(id);
        if (index >= 0) {
            store.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = findIndex(id);
        if (index >= 0) {
            store.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int index = findIndex(id);
        return index == -1 ? null : store.get(index);
    }

    /**
     * Метод позволяет найти индекс Модели по ИД
     * @param id искомый ИД
     * @return индекс в хранилище
     */
    private int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < store.getLength(); i++) {
            if (store.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

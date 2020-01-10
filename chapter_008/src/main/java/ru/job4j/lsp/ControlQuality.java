package ru.job4j.lsp;

import java.util.List;

/**
 * Class distributes products.
 *
 * @author STAS KOROBEYNIKOV.
 * @since 10.01.2020
 */
public class ControlQuality {
    /**
     * List stores.
     */
    private List<Store> listStore;

    public ControlQuality(List<Store> listStore) {
        this.listStore = listStore;
    }

    /**
     * Method determines where to send product.
     *
     * @param food product for distribution.
     */
    public void control(Food food) {
        for (Store store : listStore) {
            if (store.checkFood(food)) {
                store.addFood(food);
                break;
            }
        }
    }
}

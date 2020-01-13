package ru.job4j.lsp;

import ru.job4j.dip.Resort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class distributes products.
 *
 * @author STAS KOROBEYNIKOV.
 * @since 10.01.2020
 */
public class ControlQuality implements Resort {
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
     * @param currentDate Date.
     */
    public void control(Food food, Date currentDate) {
        for (Store store : listStore) {
            if (store.checkFood(food, currentDate)) {
                store.addFood(food);
                break;
            }
        }
    }

    /**
     * Method redistributes products to current date.
     *
     * @param currentDate Date.
     */
    @Override
    public void resort(Date currentDate) {
        List<Food> foodList = new ArrayList<>();
        for (Store store : listStore) {
            foodList.addAll(store.getAllFood());
        }
        for (Food food : foodList) {
            control(food, currentDate);
        }
    }
}

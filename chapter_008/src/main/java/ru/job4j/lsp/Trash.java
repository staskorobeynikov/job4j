package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends WareHouse {
    private List<Food> list = new ArrayList<>();

    /**
     * Method for checking product quality.
     *
     * @param food product for checking.
     * @return true - product will be send to Trash.
     */
    @Override
    public boolean checkFood(Food food) {
        boolean result = false;
        if (determineResourceProduct(food.getExpireDate(), food.getCreateDate()) < 0) {
            result = true;
        }
        return result;
    }

    /**
     * Method adds product to list products Trash.
     *
     * @param food product for adding.
     */
    @Override
    public void addFood(Food food) {
        list.add(food);
    }

    public List<Food> getList() {
        return list;
    }
}

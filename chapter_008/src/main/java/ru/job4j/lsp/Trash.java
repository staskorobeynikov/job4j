package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Date;
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
    public boolean checkFood(Food food, Date currentDate) {
        boolean result = false;
        if (determineResourceProduct(food, currentDate) < 0) {
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

    /**
     * Method to get list Foods.
     *
     * @return Array products.
     */
    @Override
    public List<Food> getAllFood() {
        List<Food> result = new ArrayList<>(list);
        list.clear();
        return result;
    }
}

package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends WareHouse {

    private List<Food> list = new ArrayList<>();

    /**
     * Method for checking product quality.
     *
     * @param food product for checking.
     * @return true - product will be send to Shop.
     */
    @Override
    public boolean checkFood(Food food) {
        boolean result = false;
        if (determineResourceProduct(food.getExpireDate(), food.getCreateDate()) <= 75
                && determineResourceProduct(food.getExpireDate(), food.getCreateDate()) > 0) {
            result = true;
            if (determineResourceProduct(food.getExpireDate(), food.getCreateDate()) < 25) {
                food.setDiscount(50);
            }
            list.add(food);
        }
        return result;
    }

    public List<Food> getList() {
        return list;
    }
}

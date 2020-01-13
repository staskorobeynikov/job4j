package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WareHouse implements Store {
    private List<Food> list = new ArrayList<>();

    /**
     * Method for checking product quality.
     *
     * @param food product for checking.
     * @return true - product will be send to WareHouse.
     */

    /**
     * Method for checking product quality.
     *
     * @param food product for checking.
     * @param currentDate Date current date.
     * @return true - product will be send to WareHouse.
     */
    @Override
    public boolean checkFood(Food food, Date currentDate) {
        boolean result = false;
        if (determineResourceProduct(food, currentDate) > 75) {
            result = true;
        }
        return result;
    }

    /**
     * Helper method for determining resource products.
     *
     * @param food product for checking.
     * @param currentDate Date current date.
     * @return int percent resource product.
     */
    public int determineResourceProduct(Food food, Date currentDate) {
        long resourceProdDate = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        long balanceProdDate = food.getExpireDate().getTime() - currentDate.getTime();
        return Math.round(balanceProdDate * 100 / resourceProdDate);
    }

    /**
     * Method adds product to list products WareHouse.
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

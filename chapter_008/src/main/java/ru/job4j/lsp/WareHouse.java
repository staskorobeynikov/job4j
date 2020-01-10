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
    @Override
    public boolean checkFood(Food food) {
        boolean result = false;
        if (determineResourceProduct(food.getExpireDate(), food.getCreateDate()) > 75) {
            result = true;
        }
        return result;
    }

    /**
     * Helper method for determining resource products.
     *
     * @param expireDate expire date product.
     * @param createDate create date product.
     * @return int percent resource product.
     */
    public int determineResourceProduct(Date expireDate, Date createDate) {
        long resourceProdDate = expireDate.getTime() - createDate.getTime();
        long balanceProdDate = expireDate.getTime() - System.currentTimeMillis();
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
}

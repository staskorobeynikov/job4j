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
            list.add(food);
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
        int result;
        long resourceProdDate = expireDate.getTime() - createDate.getTime();
        long balanceProdDate = expireDate.getTime() - System.currentTimeMillis();
        result = Math.round(balanceProdDate * 100 / resourceProdDate);
        return result;
    }

    public List<Food> getList() {
        return list;
    }
}

package ru.job4j.lsp;

import java.util.Date;
import java.util.List;

public interface Store {

    /**
     * Method for checking product quality.
     *
     * @param food product for checking.
     * @param currentDate Date current date.
     * @return true - product is good
     */
    public boolean checkFood(Food food, Date currentDate);

    /**
     * Method add product to list.
     *
     * @param food product for adding.
     */
    public void addFood(Food food);

    /**
     * Method to get list Foods.
     *
     * @return Array Food.
     */
    List<Food> getAllFood();
}

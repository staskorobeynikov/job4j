package ru.job4j.lsp;

public interface Store {
    /**
     * Method for checking product quality.
     *
     * @param food product for checking.
     * @return true - product is good
     */
    public boolean checkFood(Food food);
}

package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that forms the menu.
 */
public class Menu {
    /**
     * List actions calculator.
     */
    private List<CalcAction> actions = new ArrayList<>();

    /**
     * Method adds new action.
     * @param action Calculator action.
     */
    public void addToMenu(CalcAction action) {
        actions.add(action);
    }

    /**
     * Displays a menu.
     */
    public void showMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(String.format("%s . %s", i, actions.get(i).name()));
        }
    }

    /**
     * Method determines size list actions.
     *
     * @return int list actions size.
     */
    public int getMenuSize() {
        return actions.size();
    }

    /**
     * Method gets the result calculator action.
     */
    public double executeAction(int index, Calculator calculator, Input input, double result) {
        return actions.get(index).execute(input, calculator, result);
    }
}

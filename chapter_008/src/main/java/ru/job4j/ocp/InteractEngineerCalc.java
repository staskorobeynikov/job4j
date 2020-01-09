package ru.job4j.ocp;

import ru.job4j.calculator.Calculator;
import ru.job4j.srp.*;
/**
 *
 */
public class InteractEngineerCalc {
    /**
     * Input stream object.
     */
    private final Input input;

    /**
     * Calculator object.
     */
    private final Calculator calculator;

    /**
     * Menu object.
     */
    private final Menu menu;

    public InteractEngineerCalc(Input input, Calculator calculator, Menu menu) {
        this.input = input;
        this.calculator = calculator;
        this.menu = menu;
    }

    /**
     * Menu initialization.
     */
    public void init() {
        double result = 0;
        do {
            menu.showMenu();
            int select = input.askInt("Select: ", menu.getMenuSize());
            result = menu.executeAction(select, calculator, input, result);
            System.out.println(result);
        } while (!"y".equals(input.askStr("Exit?(y or any key): ")));
    }

    /**
     * Launch the calculator.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Calculator calculator = new EngineeringCalculator();
        Menu menu = new Menu();
        menu.addToMenu(new AddAction());
        menu.addToMenu(new DivideAction());
        menu.addToMenu(new MultiplyAction());
        menu.addToMenu(new SubtractAction());
        menu.addToMenu(new CosAction());
        menu.addToMenu(new SinAction());
        menu.addToMenu(new TanAction());
        new InteractEngineerCalc(input, calculator, menu).init();
    }
}

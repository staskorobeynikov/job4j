package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

/**
 * Class initializes and starts calculator.
 *
 * @author STAS KOROBEYNIKOV.
 * @since 09.01.2020.
 */
public class InteractCalc {
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

    public InteractCalc(Input input, Calculator calculator, Menu menu) {
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
        Calculator calculator = new Calculator();
        Menu menu = new Menu();
        menu.addToMenu(new AddAction());
        menu.addToMenu(new DivideAction());
        menu.addToMenu(new MultiplyAction());
        menu.addToMenu(new SubtractAction());
        new InteractCalc(input, calculator, menu).init();
    }
}

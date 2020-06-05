package ru.job4j.pojo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShopTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenDelete() {
        Product[] productsDelete = new Product[6];
        productsDelete[0] = new Product("Milk", 10);
        productsDelete[1] = new Product("Bread", 4);
        productsDelete[2] = new Product("Egg", 19);
        productsDelete[3] = new Product("Oil", 2);
        productsDelete[4] = new Product("Fish", 3);
        productsDelete[5] = new Product("Meat", 2);
        Shop out = new Shop();
        Product[] change = new Product[6];
        change[0] = new Product("Milk", 10);
        change[1] = new Product("Bread", 4);
        change[2] = new Product("Egg", 19);
        change[3] = new Product("Fish", 3);
        change[4] = new Product("Meat", 2);
        change[5] = null;

        Product[] result = out.delete(productsDelete, 3);

        assertThat(result, is(change));
    }

    @Test
    public void whenTestConsoleOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Shop.main(new String[0]);

        String expect = String.format(
                "Milk%s"
                        + "Bread%s"
                        + "Egg%s"
                        + "null%s"
                        + "null%s%s"
                        + "Удаляем значение из ячейки с индексом 1%s"
                        + "Milk%s"
                        + "null%s"
                        + "Egg%s"
                        + "null%s"
                        + "null%s%s"
                        + "Записываем  в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем значение из ячейки с индексом 2%s"
                        + "Milk%s"
                        + "Egg%s"
                        + "null%s"
                        + "null%s"
                        + "null%s%s"
                        + "Milk%s"
                        + "Bread%s"
                        + "Egg%s"
                        + "Fish%s"
                        + "Meat%s"
                        + "null%s",
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN
        );
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

}
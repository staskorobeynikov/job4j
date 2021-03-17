package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShopTest {
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
    public void whenLastNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int rsl = Shop.indexOfNull(products);
        assertThat(rsl, is(3));
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[1] = new Product("Milk", 10);
        int rsl = Shop.indexOfNull(products);
        assertThat(rsl, is(0));
    }

    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[1];
        products[0] = new Product("Milk", 10);
        int rsl = Shop.indexOfNull(products);
        assertThat(rsl, is(-1));
    }
}
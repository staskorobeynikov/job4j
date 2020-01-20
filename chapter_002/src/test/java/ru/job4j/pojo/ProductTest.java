package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void whenGetName() {
        Product product = new Product("milk", 4);

        String result = product.getName();

        assertThat(result, is("milk"));
    }

    @Test
    public void whenSetName() {
        Product product = new Product(" ", 4);
        product.setName("milk");

        String result = product.getName();

        assertThat(result, is("milk"));

    }

    @Test
    public void whenGetCount() {
        Product product = new Product("milk", 4);

        int result = product.getCount();

        assertThat(result, is(4));
    }

    @Test
    public void whenSetCount() {
        Product product = new Product("milk", 0);
        product.setCount(4);

        int result = product.getCount();

        assertThat(result, is(4));
    }

    @Test
    public void whenEqualsProductIsTrue() {
        Product product = new Product("milk", 1);
        Product product1 = new Product("milk", 1);

        boolean result = product.equals(product1);

        assertThat(result, is(true));
    }

    @Test
    public void whenEqualsProductIsTrue1() {
        Product product = new Product("milk", 1);

        boolean result = product.equals(product);

        assertThat(result, is(true));
    }

    @Test
    public void whenEqualsProductIsFalse1() {
        Product product = new Product("milk", 1);
        Product product1 = null;

        boolean result = product.equals(product1);

        assertThat(result, is(false));
    }

    @Test
    public void whenEqualsProductIsFalse2() {
        Product product = new Product("milk", 1);
        Book book = new Book("milk", 1);

        boolean result = product.equals(book);

        assertThat(result, is(false));
    }

    @Test
    public void whenEqualsProductIsFalseCount() {
        Product product = new Product("milk", 1);
        Product product1 = new Product("milk", 2);

        boolean result = product.equals(product1);

        assertThat(result, is(false));
    }

    @Test
    public void whenEqualsProductIsFalseName() {
        Product product = new Product("milk", 1);
        Product product1 = new Product("milk1", 1);

        boolean result = product.equals(product1);

        assertThat(result, is(false));
    }

    @Test
    public void whenGetHashCode() {
        Product product = new Product("milk", 1);

        int result = product.hashCode();

        assertThat(result, is(103899911));
    }

    @Test
    public void whenGetToString() {
        Product product = new Product("milk", 1);

        String result = product.toString();

        assertThat(result, is("Product: milk, 1."));
    }
}
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
}
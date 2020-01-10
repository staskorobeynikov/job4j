package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    private WareHouse wareHouse;
    private Shop shop;
    private Trash trash;
    private ControlQuality controlQuality;

    @Before
    public void init() {
        wareHouse = new WareHouse();
        shop = new Shop();
        trash = new Trash();
        controlQuality = new ControlQuality(Arrays.asList(wareHouse, shop, trash));
    }

    @Test
    public void whenResourceProductIsMore75Percent() {
        List<Food> list = Arrays.asList(new Food("Keks", new Date(1579089600000L),
                new Date(1578571200000L), 50, 0));
        for (Food food : list) {
            controlQuality.control(food);
        }
        assertThat(wareHouse.getList().get(0).getName(), is("Keks"));
    }

    @Test
    public void whenResourceProductIsLess75More25Percent() {
        List<Food> list = Arrays.asList(new Food("Milk", new Date(1578916800000L),
                new Date(1578571200000L), 100, 0));
        for (Food food : list) {
            controlQuality.control(food);
        }
        assertThat(shop.getList().get(0).getName(), is("Milk"));
    }

    @Test
    public void whenResourceProductIsLess25More0Percent() {
        List<Food> list = Arrays.asList(new Food("Chocolate", new Date(1578700800000L),
                new Date(1578571200000L), 100, 0));
        for (Food food : list) {
            controlQuality.control(food);
        }
        assertThat(shop.getList().get(0).getName(), is("Chocolate"));
        assertThat(shop.getList().get(0).getDiscount(), is(50));
    }

    @Test
    public void whenResourceProductIsLess0Percent() {
        List<Food> list = Arrays.asList(new Food("Kefir", new Date(1578614400000L),
                new Date(1578571200000L), 100, 0));
        for (Food food : list) {
            controlQuality.control(food);
        }
        assertThat(trash.getList().get(0).getName(), is("Kefir"));
    }
}
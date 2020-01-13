package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

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

    /**
     * currentDate - 1578873600000L - 13 january 2020 00:00:00.
     * expireDate - 1579910400000L - 25 january 2020 00:00:00.
     * createDate - 1578787200000L - 12 january 2020 00:00:00.
     */
    @Test
    public void whenResourceProductIsMore75Percent() {
        Date currentDate = new Date(1578873600000L);
        Food food = new Food("Keks", new Date(1579910400000L), new Date(1578571200000L), 50, 0);

        controlQuality.control(food, currentDate);

        assertThat(wareHouse.getList().get(0).getName(), is("Keks"));
    }

    /**
     * currentDate - 1578873600000L - 13 january 2020 00:00:00.
     * expireDate - 1579305600000L - 18 january 2020 00:00:00.
     * createDate -1578614400000L - 10 january 2020 00:00:00.
     */
    @Test
    public void whenResourceProductIsLess75More25Percent() {
        Date currentDate = new Date(1578873600000L);
        Food food = new Food("Milk", new Date(1579305600000L), new Date(1578614400000L), 100, 0);

        controlQuality.control(food, currentDate);

        assertThat(shop.getList().get(0).getName(), is("Milk"));
    }

    /**
     * currentDate - 1578873600000L - 13 january 2020 00:00:00.
     * expireDate - 1579046400000L - 16 january 2020 00:00:00.
     * createDate - 1577836800000L - 01 january 2020 00:00:00.
     */
    @Test
    public void whenResourceProductIsLess25More0Percent() {
        Date currentDate = new Date(1578873600000L);
        Food food = new Food("Chocolate", new Date(1579046400000L), new Date(1577836800000L), 100, 0);

        controlQuality.control(food, currentDate);

        assertThat(shop.getList().get(0).getName(), is("Chocolate"));
        assertThat(shop.getList().get(0).getDiscount(), is(50));
    }

    /**
     * currentDate - 1578873600000L - 13 january 2020 00:00:00.
     * expireDate - 1579046400000L - 12 january 2020 00:00:00.
     * createDate - 1577836800000L - 01 january 2020 00:00:00.
     */
    @Test
    public void whenResourceProductIsLess0Percent() {
        Date currentDate = new Date(1578873600000L);
        Food food = new Food("Kefir", new Date(1578787200000L), new Date(1577836800000L), 100, 0);

        controlQuality.control(food, currentDate);

        assertThat(trash.getList().get(0).getName(), is("Kefir"));
    }

    /**
     * currentDate - 1578873600000L - 13 january 2020 00:00:00.
     * newCurrentDate - 1579305600000L - 18 january 2020 00:00:00.
     * expireDate - 1579046400000L - 20 january 2020 00:00:00.
     * createDate - 1577836800000L - 01 january 2020 00:00:00.
     */
    @Test
    public void whenResortMethodTest() {
        Date currentDate = new Date(1578873600000L);
        Food food = new Food("Chocolate", new Date(1579478400000L), new Date(1577836800000L), 100, 0);

        controlQuality.control(food, currentDate);

        assertThat(shop.getList().get(0).getName(), is("Chocolate"));
        assertThat(shop.getList().get(0).getDiscount(), is(0));

        Date newCurrentDate = new Date(1579305600000L);

        controlQuality.resort(newCurrentDate);

        assertThat(shop.getList().get(0).getName(), is("Chocolate"));
        assertThat(shop.getList().get(0).getDiscount(), is(50));
    }

    /**
     * currentDate - 1578873600000L - 13 january 2020 00:00:00.
     * newCurrentDate - 1579305600000L - 18 january 2020 00:00:00.
     * expireDate - 1579910400000L - 25 january 2020 00:00:00.
     * createDate - 1578787200000L - 12 january 2020 00:00:00.
     */
    @Test
    public void whenResortMethodTestFoodRedistributesFromWarehouseToShop() {
        Date currentDate = new Date(1578873600000L);
        Food food = new Food("Keks", new Date(1579910400000L), new Date(1578571200000L), 50, 0);

        controlQuality.control(food, currentDate);

        assertThat(wareHouse.getList().get(0).getName(), is("Keks"));

        Date newCurrentDate = new Date(1579305600000L);

        controlQuality.resort(newCurrentDate);

        assertThat(shop.getList().get(0).getName(), is("Keks"));
    }
}
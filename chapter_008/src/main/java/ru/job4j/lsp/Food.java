package ru.job4j.lsp;

import java.util.Date;

public class Food {
    /**
     * Name product.
     */
    private String name;
    /**
     * Date expire date product.
     */
    private Date expireDate;
    /**
     * Date create date product.
     */
    private Date createDate;
    /**
     * Price product.
     */
    private int price;
    /**
     * Discount for price product.
     */
    private int discount;

    public Food(String name, Date expireDate, Date createDate, int price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

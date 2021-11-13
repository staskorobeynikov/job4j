package ru.job4j.inheritance;

public final class LiquidationProduct extends Product {
    private Product product;

    public LiquidationProduct(String name, int price) {
        super(name, price);
        product = new Product(name, price);
    }

    @Override
    public String label() {
        return product.label();
    }
}

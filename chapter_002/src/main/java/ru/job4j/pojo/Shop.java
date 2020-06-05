package ru.job4j.pojo;

public class Shop {
    public Product[]delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
            if (i == products.length - 1) {
                products[products.length - 1] = null;
                break;
            }
            products[i] = products[i + 1];
        }
        return products;
    }
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product pr = products[i];
            if (pr != null) {
                System.out.println(pr.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");
        products[1] = null;
        for (int i = 0; i < products.length; i++) {
            Product pr = products[i];
            if (pr != null) {
                System.out.println(pr.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        System.out.println("Записываем  в ячейку с индексом 1 значение ячейки "
                +
                "с индексом 2 и удаляем значение из ячейки с индексом 2");
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product pr = products[i];
            if (pr != null) {
                System.out.println(pr.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        Product[] productsDelete = new Product[6];
        productsDelete[0] = new Product("Milk", 10);
        productsDelete[1] = new Product("Bread", 4);
        productsDelete[2] = new Product("Egg", 19);
        productsDelete[3] = new Product("Oil", 2);
        productsDelete[4] = new Product("Fish", 3);
        productsDelete[5] = new Product("Meat", 2);
        //Product out = new Product();
        Shop out = new Shop();
        out.delete(productsDelete, 3);
        for (int i = 0; i < productsDelete.length; i++) {
            Product pr = productsDelete[i];
            if (pr != null) {
                System.out.println(pr.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}

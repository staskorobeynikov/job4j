package ru.job4j.pojo;

public class Library {
    public static void  main(String[] args) {
        Book book1 = new Book("Евгений Онегин", 3);
        Book book2 = new Book("Китайский язык", 2);
        Book book3 = new Book("Инструкция пользователя", 5);
        Book book4 = new Book("Clean Code", 1);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[2];
        books[2] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println();
        System.out.println("Show book with name - Clean code");
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b.getName().equals("Clean Code")) {
                System.out.println(b.getName() + " - " + b.getCount());
            }
        }
    }
}

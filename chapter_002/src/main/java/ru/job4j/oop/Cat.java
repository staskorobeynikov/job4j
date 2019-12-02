package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;
    public void  show() {
        System.out.println("Cat's name is " + this.name);
        System.out.println("He eats " + this.food);
    }
    public void giveNick(String nick){
        this.name = nick;
    }
    public void eat(String meat){
        this.food = meat;
    }
    public static void main(String[] args) {
        Cat nickname = new Cat();
        nickname.giveNick("gav");
        nickname.eat("kotleta");
        nickname.show();
        System.out.println();
        nickname.giveNick("black");
        nickname.eat("fish");
        nickname.show();
    }
}

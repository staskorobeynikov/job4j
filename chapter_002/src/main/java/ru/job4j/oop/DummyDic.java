package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng){
        String say = "Неизвестное слово. ";
        return say + eng;
    }
    public static void main(String[] args){
        DummyDic dic = new DummyDic();
        String answer = dic.engToRus("Inheritance");
        System.out.println("Dic answers " + answer);
    }
}

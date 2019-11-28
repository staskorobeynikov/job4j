package ru.job4j.condition;

public class SqMax {
    public static int max(int first, int second, int third, int forth){
        int result = forth;
        if (first>second){
            if(first>third){
                if (first>forth){
                    // указана не та переменная при возврате
                    // вместо third ставлю first
                    result = first;
                }
            }
        } else if(second>third){
            if (second>forth){
                // указана не та переменная при возврате
                // вместо first ставлю second
                result = second;
            }
        }else if (third>forth){
            // указана не та переменная при возврате
            // вместо  second ставлю third
            result = third;
        }
        return result;
    }
}

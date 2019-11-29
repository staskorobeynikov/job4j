package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num){
        boolean prime = false;
        for(int i=1; i<=num; i++){
            if(num==1){
                prime=false;
            } else if (num%i==0 && i!=num && i!=1){
                prime=false;
                break;
            } else {
                prime=true;
            }
        }
        return prime;
    }
}

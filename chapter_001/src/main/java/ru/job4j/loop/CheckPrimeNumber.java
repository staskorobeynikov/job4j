package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num){
        boolean prime = false;
        for(int i=1; i<=num; i++){
            if(i>1){
                if(num%i==0&&num!=i){
                    prime=false;
                    break;
                }else{
                    prime=true;
                }
            } else{
                prime=true;
            }
        }
        return prime;
    }
}

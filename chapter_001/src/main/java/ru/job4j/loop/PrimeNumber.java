package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish){
        int count = 0;
        for(int i=2; i<=finish; i++){
            for(int j=2; j<=i; j++){
                if(i%j==0&&i!=j) {
                    break;
                } else if(i%j==0&&i==j){
                    count=count+1;
                }else{
                    continue;
                }
            }
        }
        return count;
    }
}

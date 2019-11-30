package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish){
        int count = 0;
        for(int i=2; i<=finish; i++){
            CheckPrimeNumber primeNumber = new CheckPrimeNumber();
            if (primeNumber.check(i)==true){
                count++;
            }
        }
        return count;
    }
}

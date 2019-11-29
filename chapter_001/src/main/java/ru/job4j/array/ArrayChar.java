package ru.job4j.array;

public class ArrayChar {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = false;
        for (int i=0; i<pref.length; i++){
            if (pref[i]==word[i]){
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}

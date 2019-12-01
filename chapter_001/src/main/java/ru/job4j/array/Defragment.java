package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                // переместить первую не null ячейку
                // Здесь нужен цикл while
                while(index<array.length){
                    if(array[index]!=null){
                        String temp = cell;
                        cell = array[index];
                        array[index] = temp;
                        index=0;
                        break;
                    }
                    index++;
                }
            }
          System.out.print(cell + " ");
        }
        return array;
    }
    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}

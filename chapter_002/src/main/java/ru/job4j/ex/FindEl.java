package ru.job4j.ex;

public class FindEl {
    public int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found.");
        }
        return result;
    }

    public static void main(String[] args) {
        FindEl findEl = new FindEl();
        int result;
        try {
            result = findEl.indexOf(new String[] {"name", "name1", "name2"}, "name2");
            System.out.println("Index element is: " + result);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package ru.job4j.list;

public class FindCycle<E> {
    /**
     * Метод позволяет определить содержит ли список замыкания
     * @return true - список содержит цикл
     */
    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        Node<E> oneStep = first;
        Node<E> twoStep = first;
        while (oneStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                result = true;
                break;
            }
        }
        return result;
    }
}

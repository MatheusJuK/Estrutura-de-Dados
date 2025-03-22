package Exercicios;
import Fila.Deque;
public class Exercicio2 {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.enqueueLeft(0);
        deque.enqueueLeft(1);
        deque.enqueueLeft(2);
        deque.enqueueLeft(3);
        deque.enqueueLeft(4);
        deque.enqueueLeft(5);
        deque.imprimir();
        deque.rotacionar(2);
        deque.imprimir();
    }
}

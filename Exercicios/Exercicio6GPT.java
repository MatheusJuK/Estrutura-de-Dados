package Exercicios;
import Lista.ListaEstatica;
public class Exercicio6GPT {
    public static void main(String[] args) {
        ListaEstatica<Integer> lista = new ListaEstatica<>(3);
        lista.add(0, 0);
        lista.add(1, 1);
        lista.add(2, 2);
        lista.imprimir();
        lista.addCircular(3);
        lista.imprimir();
    }
}

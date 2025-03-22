package Exercicios;
import Lista.ListaDinamica;
public class Exercicio1 {
    public static void main(String[] args) {
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        lista.add(10, 0);
        lista.add(9, 1);
        lista.add(8, 2);
        lista.add(7, 3);
        lista.add(6, 4);
        lista.add(5, 5);
        lista.add(4, 6);
        lista.add(3, 7);
        lista.add(2, 8);
        lista.add(0, 9);
        lista.add(0, 10);
        lista.add(0, 11);
        lista.ordenarLista();
        lista.imprimir();
    }
}

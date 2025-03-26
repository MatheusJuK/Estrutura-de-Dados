package Exercicios;
import Lista.ListaDinamica;
public class Exercicio1GPT{
    public static void main(String[] args) {
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        lista.add(5, 0);
        lista.add(6, 1);
        lista.add(4, 2);
        lista.add(5, 3);
        lista.add(2, 4);
        lista.add(1, 5);
        lista.add(7, 6);
        lista.add(8, 7);
        lista.add(0, 8);
        lista.add(9, 9);
        lista.imprimir();
        lista.ordenarMenoresQueX(6);
        lista.imprimir();
    }
}
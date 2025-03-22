package Exercicios;
import Lista.ListaDuplamenteLigadaCircular;
import Lista.NodeListas;
public class Exercicio3 {
    public static void main(String[] args) {
        ListaDuplamenteLigadaCircular<Integer> lista = new ListaDuplamenteLigadaCircular<>();
        for (int i = 0; i < 10; i++) {
            lista.add(i, i);
        }
        lista.imprimir();
        NodeListas<Integer> inicio = lista.head;
        NodeListas<Integer> fim = lista.head;
        while (inicio.valor != 4) {
            inicio = inicio.prox;
        }
        while (fim.valor != 6) {
            fim = fim.prox;
        }
        lista.deslocar(inicio,fim);
        lista.imprimir();
    }
}

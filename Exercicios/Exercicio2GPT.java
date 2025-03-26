package Exercicios;
import Lista.ListaDuplamenteLigada;
public class Exercicio2GPT {
    public static void main(String[] args) {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        for(int i = 0; i < 10; i++){
            lista.add(i,i);
        }
        lista.imprimir();
        lista.inverterSegmento(4, 7);
        lista.imprimir();
    }
}

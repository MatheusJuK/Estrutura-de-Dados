package Exercicios;
import Lista.ListaDuplamenteLigada;
public class Exercicio5GPT {
    public static void main(String[] args) {
        ListaDuplamenteLigada<Integer> lista1 = new ListaDuplamenteLigada<>();
        ListaDuplamenteLigada<Integer> lista2 = new ListaDuplamenteLigada<>();
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                lista1.add(i, lista1.tamanho);
            }else{
                lista2.add(i, lista2.tamanho);
            }
        }
        lista1.imprimir();
        lista2.imprimir();
        lista.juntarListasOrdenadas(lista1, lista2, lista);
        lista.imprimir();
    }
}

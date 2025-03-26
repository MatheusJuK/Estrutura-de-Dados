package Exercicios;
import Lista.ListaDinamica;
public class Exercicio3GPT {
    public static void main(String[] args) {
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        ListaDinamica<Integer> lista1 = new ListaDinamica<>();
        ListaDinamica<Integer> lista2 = new ListaDinamica<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                lista1.add(i, lista1.tamanho);
            }else{
                lista2.add(i, lista2.tamanho);
            }
        }
        lista.justarListasOrdenadas(lista1, lista2, lista);
        lista.imprimir();
    }
}

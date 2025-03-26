package Exercicios;
import Lista.ListaDuplamenteLigadaCircular;
public class Exercicio4GPT {
    public static void main(String[] args) {
        ListaDuplamenteLigadaCircular<Integer> lista = new ListaDuplamenteLigadaCircular<>();
        for(int i = 1; i < 10; i++){
            lista.add(i,i - 1);
        }
        lista.imprimir();
        lista.OrdenarNoCentral();
        lista.imprimir();
    }
}

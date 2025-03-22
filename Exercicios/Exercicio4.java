package Exercicios;
import Fila.FilaPrioridade;
public class Exercicio4 {
    public static void main(String[] args) {
        FilaPrioridade<Integer> hallDaFama = new FilaPrioridade<>();
        for (int i = 0; i < 8; i++) {
            hallDaFama.enqueuePrioridade(i, i);
        }
        hallDaFama.imprimir();
        hallDaFama.imprimirMaiores(2);
    }
}

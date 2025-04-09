package Grafo;

public class Node<Tipo> {
    Tipo valor;
    Node<Tipo> proximo;
    Node<Tipo> anterior;

    public Node(Tipo valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

public class Node<Tipo> {
    Tipo valor;
    Node<Tipo> prox;
    Node<Tipo> ant;
    Node(Tipo valor){
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}

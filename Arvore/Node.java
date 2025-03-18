public class Node<Tipo>{
    Tipo valor;
    Node<Tipo> direita;
    Node<Tipo> esquerda;
    Node(Tipo valor){
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }
}

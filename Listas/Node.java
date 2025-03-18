public class Node<Tipo> {
    Tipo valor;
    int prioridade;
    Node<Tipo> prox;
    Node<Tipo> ant;
    Node(Tipo valor){
        this.valor = valor;
        this.prioridade = 0;
        this.prox = null;
        this.ant = null;
    }
    Node(Tipo valor,int prioridade){
        this.valor = valor;
        this.prioridade = prioridade;
        this.prox = null;
        this.ant = null;
    }
}

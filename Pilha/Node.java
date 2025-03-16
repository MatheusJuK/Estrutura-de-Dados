public class Node {
    int valor;
    int prioridade;
    Node prox;
    Node ant;
    Node(int valor){
        this.valor = valor;
        this.prioridade = 0;
        this.prox = null;
        this.ant = null;
    }
    Node(int valor,int prioridade){
        this.valor = valor;
        this.prioridade = prioridade;
        this.prox = null;
        this.ant = null;
    }
}

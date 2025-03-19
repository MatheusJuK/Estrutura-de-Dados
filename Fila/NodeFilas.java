package Fila;

public class NodeFilas<Tipo> {
    Tipo valor;
    int prioridade;
    NodeFilas<Tipo> prox;
    NodeFilas<Tipo> ant;
    public NodeFilas(Tipo valor){
        this.valor = valor;
        this.prioridade = 0;
        this.prox = null;
        this.ant = null;
    }
    public NodeFilas(Tipo valor,int prioridade){
        this.valor = valor;
        this.prioridade = prioridade;
        this.prox = null;
        this.ant = null;
    }
}


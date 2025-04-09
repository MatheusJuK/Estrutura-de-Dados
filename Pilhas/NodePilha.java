package Pilhas;

public class NodePilha<Tipo> {
    public Tipo valor;
    NodePilha<Tipo> prox;  
    public NodePilha(Tipo valor){
        this.valor = valor;
        this.prox = null;
    }
}


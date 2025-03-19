package Pilhas;

public class NodePilha<Tipo> {
    Tipo valor;
    NodePilha<Tipo> prox;  
    public NodePilha(Tipo valor){
        this.valor = valor;
        this.prox = null;
    }
}


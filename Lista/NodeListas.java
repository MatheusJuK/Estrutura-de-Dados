package Lista;
public class NodeListas<Tipo> {
    Tipo valor;
    NodeListas<Tipo> prox;
    NodeListas<Tipo> ant;
    public NodeListas(Tipo valor){
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}

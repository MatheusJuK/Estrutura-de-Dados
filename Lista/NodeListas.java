package Lista;
public class NodeListas<Tipo> {
    public Tipo valor;
    public NodeListas<Tipo> prox;
    public NodeListas<Tipo> ant;
    public NodeListas(Tipo valor){
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}

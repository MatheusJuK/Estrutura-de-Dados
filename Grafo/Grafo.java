package Grafo;
import Lista.ListaDinamica;
public class Grafo<Tipo> {
    ListaDinamica<NodeGrafo<Tipo>> nos;
    
    public Grafo(ListaDinamica<NodeGrafo<Tipo>> lista){
        this.nos = lista;
    }
    public static void main(String[] args) {
        ListaDinamica<NodeGrafo<String>> lista = new ListaDinamica<>();
        NodeGrafo<String> Matheus = new NodeGrafo<String>("Matheus");
        Grafo<String> grafo = new Grafo<String>(lista);
        grafo.nos.add(Matheus, 0);
        grafo.nos.imprimir();
    }
}

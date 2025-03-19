package Grafo;
import Lista.ListaDinamica;
public class NodeGrafo<Tipo> {
    Tipo valor;
    ListaDinamica<Arestas<Tipo>> arestasDeSaida = new ListaDinamica<>();
    public NodeGrafo(Tipo valor){
        this.valor = valor;
    }
}

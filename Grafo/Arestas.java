package Grafo;

public class Arestas<Tipo> {
    int peso;
    NodeGrafo<Tipo> inicio;
    NodeGrafo<Tipo> fim;
    public Arestas(int peso, NodeGrafo<Tipo> inicio,NodeGrafo<Tipo> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }
}

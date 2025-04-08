package Grafo;

public class Aresta<Tipo> {
    public int peso;
    public Vertice<Tipo> inicio;
    public Vertice<Tipo> fim;

    public Aresta(int peso, Vertice<Tipo> inicio, Vertice<Tipo> fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }
}

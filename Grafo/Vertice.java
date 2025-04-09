package Grafo;


public class Vertice<Tipo> {
    public Tipo valor;
    public Lista<Aresta<Tipo>> arestasEntrada;
    public Lista<Aresta<Tipo>> arestasSaida;

    public Vertice(Tipo valor) {
        this.valor = valor;
        this.arestasEntrada = new Lista<>();
        this.arestasSaida = new Lista<>();
    }
    public void addArestaEntrada(Aresta<Tipo> aresta) {
        this.arestasEntrada.add(aresta);
    }
    public void addArestaSaida(Aresta<Tipo> aresta) {
        this.arestasSaida.add(aresta);
    }

}

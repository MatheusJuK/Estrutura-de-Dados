package Grafo;

import java.util.ArrayList;

public class Vertice<Tipo> {
    public Tipo valor;
    public ArrayList<Aresta<Tipo>> arestasEntrada;
    public ArrayList<Aresta<Tipo>> arestasSaida;

    public Vertice(Tipo valor) {
        this.valor = valor;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
    }
    public void addArestaEntrada(Aresta<Tipo> aresta) {
        this.arestasEntrada.add(aresta);
    }
    public void addArestaSaida(Aresta<Tipo> aresta) {
        this.arestasSaida.add(aresta);
    }

}

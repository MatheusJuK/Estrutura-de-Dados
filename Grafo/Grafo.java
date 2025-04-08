package Grafo;

import java.util.ArrayList;

public class Grafo<Tipo> {
    public ArrayList<Vertice<Tipo>> vertices;
    public ArrayList<Aresta<Tipo>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void addVertice(Tipo valor){
        Vertice<Tipo> vertice = new Vertice<>(valor);
        this.vertices.add(vertice);
    }
    public void addAresta(int peso, Tipo dadoInicio, Tipo dadoFim){
        Vertice<Tipo> inicio = this.getVertice(dadoInicio);
        Vertice<Tipo> fim = this.getVertice(dadoFim);
        Aresta<Tipo> aresta = new Aresta<>(peso, inicio, fim);
        this.arestas.add(aresta);
        inicio.addArestaSaida(aresta);
        fim.addArestaEntrada(aresta);
        System.out.println("Adicionando aresta de " + inicio.valor + " para " + fim.valor + " com peso " + peso);
    }

    public Vertice<Tipo> getVertice(Tipo valor){
        Vertice<Tipo> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).valor.equals(valor)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void BFS(){
        ArrayList<Vertice<Tipo>> marcados = new ArrayList<>();
        ArrayList<Vertice<Tipo>> fila = new ArrayList<>();

        Vertice<Tipo> atual = this.vertices.get(4);
        marcados.add(atual);
        System.out.println(atual.valor);
        fila.add(atual);
        while (!fila.isEmpty()) {
            Vertice<Tipo> visitado = fila.get(0);
            for (int i = 0; i < visitado.arestasSaida.size(); i++) {
                Vertice<Tipo> vizinho = visitado.arestasSaida.get(i).fim;
                if (!marcados.contains(vizinho)) {
                    marcados.add(vizinho);
                    System.out.println(vizinho.valor);
                    fila.add(vizinho);                    
                }
            }
            fila.remove(0);
        }
    }
}

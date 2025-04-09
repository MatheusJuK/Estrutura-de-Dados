package Grafo;
import Pilhas.Pilha;

public class Grafo<Tipo> {
    public Lista<Vertice<Tipo>> vertices;
    public Lista<Aresta<Tipo>> arestas;

    public Grafo() {
        this.vertices = new Lista<>();
        this.arestas = new Lista<>();
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
        for (int i = 0; i < this.vertices.tamanho; i++) {
            if (this.vertices.get(i).valor.equals(valor)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void BFS(){
        System.out.println("BFS: ");
        Lista<Vertice<Tipo>> marcados = new Lista<>();
        Lista<Vertice<Tipo>> fila = new Lista<>();

        Vertice<Tipo> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.valor);
        fila.add(atual);
        while (fila.tamanho != 0) {
            Vertice<Tipo> visitado = fila.get(0);
            for (int i = 0; i < visitado.arestasSaida.tamanho; i++) {
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
    public void DFS(){
        Lista<Vertice<Tipo>> marcados = new Lista<>();
        Pilha<Vertice<Tipo>> pilha = new Pilha<>();
        for (int i = 0; i < this.vertices.tamanho; i++) {
            Vertice<Tipo> atual = this.vertices.get(i);
            if (atual.arestasEntrada.tamanho == 0 && i != 0) {
                break;
            }
            if (!marcados.contains(atual)) {
                marcados.add(atual);
                pilha.push(atual);
            }
            for (int j = 0; j < atual.arestasSaida.tamanho; j++) {
                Vertice<Tipo> vizinho = atual.arestasSaida.get(j).fim;
                if (!marcados.contains(vizinho)) {
                    marcados.add(vizinho);
                    pilha.push(vizinho);
                }
            }
        }   
        System.out.println("DFS: ");
        int tamanho = pilha.tamanho;
        for (int i = 0; i < tamanho; i++) {
            System.out.println(pilha.get(i).valor);
        }
    }
}

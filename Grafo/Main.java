package Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");
        grafo.addVertice("G");
        
        grafo.addAresta(2,"A","B");
        grafo.addAresta(2,"A","G");
        grafo.addAresta(1,"B","C");
        grafo.addAresta(3,"C","D");
        grafo.addAresta(1,"D","E");
        grafo.addAresta(3,"E","F");

        grafo.BFS();
        grafo.DFS();
    }
}

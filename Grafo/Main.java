package Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        
        grafo.addAresta(2,"A","B");
        grafo.addAresta(1,"A","C");
        grafo.addAresta(3,"B","D");
        grafo.addAresta(1,"D","C");
        grafo.addAresta(3,"E","A");
        grafo.addAresta(2,"E","B");

        grafo.BFS();
    }
}

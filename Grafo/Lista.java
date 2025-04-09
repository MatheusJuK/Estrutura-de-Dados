package Grafo;

public class Lista<Tipo> {
    Node<Tipo> head;
    Node<Tipo> tail;
    int tamanho;
    public Lista(){
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }
    public void add(Tipo objeto){
        Node<Tipo> novo = new Node<>(objeto);
        if (this.head == null) {
            this.head = novo;
            this.tail = novo;
        } else {
            this.tail.proximo = novo;
            novo.anterior = this.tail;
            this.tail = novo;
        }
        this.tamanho++;
    }
    public void imprimir(){
        Node<Tipo> atual = this.head;
        while (atual != null) {
            System.out.println(atual.valor);
            if (atual.proximo != null) {
                atual = atual.proximo;
            }else {
                break;
            }
        }
    }
    public Tipo get(int index){
        Node<Tipo> atual = this.head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }
    public Tipo remove(int index){
        Node<Tipo> atual = this.head;
        Tipo removido;
        removido = atual.valor;
        if (this.tamanho == 1) {
            this.head = null;
            this.tail = null;
            this.tamanho--;
            return removido;
        }else{
            Node<Tipo> NoRemovido = atual;
            this.head = NoRemovido.proximo;
            NoRemovido.proximo = null;
            this.head.anterior = null;
            this.tamanho--;
            return removido;
        }
    }
    public boolean contains(Tipo objeto){
        Node<Tipo> atual = this.head;
        while (atual != null) {
            if (atual.valor.equals(objeto)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
    public static void main(String[] args) {
        Lista<Vertice<String>> lista = new Lista<>();
        Lista<Aresta<String>> listaArestas = new Lista<>();
        Vertice<String> vertice1 = new Vertice<>("A");
        Vertice<String> vertice2 = new Vertice<>("B");
        Vertice<String> vertice3 = new Vertice<>("C");
        lista.add(vertice1);
        lista.add(vertice2);
        lista.add(vertice3);
        Aresta<String> aresta1 = new Aresta<>(1, vertice1, vertice2);
        Aresta<String> aresta2 = new Aresta<>(2, vertice2, vertice3);
        listaArestas.add(aresta1);
        listaArestas.add(aresta2);
        lista.imprimir();
        listaArestas.imprimir();
    }
}

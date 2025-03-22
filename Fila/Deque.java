package Fila;

public class Deque<Tipo> {
    NodeFilas<Tipo> head, tail;
    int tamanho;

    public Deque() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean enqueueLeft(Tipo valor) {
        NodeFilas<Tipo> novo = new NodeFilas<>(valor);
        if (tamanho == 0) {
            this.head = novo;
            this.tail = novo;
        }else{
            novo.prox = this.head;
            this.head.ant = novo;
            this.head = novo;
        }
        tamanho++;
        return true;
    }
    public boolean enqueueRight(Tipo valor) {
        NodeFilas<Tipo> novo = new NodeFilas<>(valor);
        if (tamanho == 0) {
            this.head = novo;
            this.tail = novo;
        }else{
            tail.prox = novo;
            novo.ant = this.tail;
            this.tail = novo;
        }
        tamanho++;
        return true;
    }

    public void imprimir() {
        NodeFilas<Tipo> atual = this.head;
        for (int i = this.tamanho; i > 0; i--) {
            if (i == 1) {
                System.out.print(atual.valor);
                atual = atual.prox;
            } else {
                System.out.print(atual.valor + "<->");
                atual = atual.prox;
            }
        }
        System.out.println();
    }

    public NodeFilas<Tipo> dequeueLeft() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na deque");
        }
        NodeFilas<Tipo> elemento;
        if (head == tail) {
            elemento = this.head;
            this.head = null;
            this.tail = null;
        }else{
            elemento = this.head;
            this.head = this.head.prox;
            elemento.prox = null;
            head.ant = null;
        }
        tamanho--;
        return elemento;
    }
    public NodeFilas<Tipo> dequeueRight() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na deque");
        }
        NodeFilas<Tipo> elemento;
        if (head == tail) {
            elemento = this.head;
            this.head = null;
            this.tail = null;
        }else{
            elemento = this.tail;
            this.tail = this.tail.ant;
            elemento.ant = null;
            tail.prox = null;
        }
        tamanho--;
        return elemento;
    }
    public void rotacionar(int k){
        for (int i = 0; i < k; i++) {
            NodeFilas<Tipo> elemento = this.tail;
            this.tail = elemento.ant;
            elemento.prox = this.head;
            this.head.ant = elemento;
            elemento.ant = null;
            tail.prox = null;
            this.head = elemento;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.imprimir();
        deque.enqueueLeft(5);
        deque.enqueueLeft(10);
        deque.enqueueLeft(15);
        deque.enqueueLeft(20);
        deque.enqueueLeft(25);
        deque.enqueueLeft(30);
        deque.enqueueLeft(35);
        deque.enqueueLeft(40);
        deque.enqueueLeft(45);
        deque.imprimir();
        deque.dequeueLeft();
        deque.dequeueLeft();
        deque.dequeueLeft();
        deque.dequeueLeft();
        deque.dequeueLeft();
        deque.dequeueLeft();
        deque.imprimir();
        deque.enqueueRight(1);
        deque.dequeueRight();
    }
}

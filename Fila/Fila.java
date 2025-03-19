package Fila;

public class Fila<Tipo> {
    NodeFilas<Tipo> head, tail;
    int tamanho;

    public Fila() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    boolean enqueue(Tipo valor) {
        NodeFilas<Tipo> novo = new NodeFilas<>(valor);
        if (tamanho == 0) {
            this.head = novo;
            this.tail = novo;
        } else {
            novo.prox = this.head;
            this.head = novo;
        }
        tamanho++;
        return true;
    }

    void imprimir() {
        NodeFilas<Tipo> atual = this.head;
        for (int i = this.tamanho; i > 0; i--) {
            if (i == 1) {
                System.out.print(atual.valor);
            } else {
                System.out.print(atual.valor + "->");
                atual = atual.prox;
            }
        }
        System.out.println();
    }

    NodeFilas<Tipo> dequeue() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na fila");
            return null;
        }
        NodeFilas<Tipo> elemento;

        if (this.head == this.tail) {
            elemento = this.head;
            this.head = null;
            this.tail = null;
        } else {
            NodeFilas<Tipo> atual = this.head;
            while(atual.prox != this.tail){
                atual = atual.prox;
            }

            elemento = atual.prox;
            this.tail = atual;
            atual.prox = null;
        }

        tamanho--;
        return elemento;
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(5);
        fila.enqueue(10);
        fila.imprimir();
        fila.dequeue();
        fila.imprimir();
    }
}

package Fila;

public class FilaPrioridade<Tipo> {
    NodeFilas<Tipo> head, tail;
    int tamanho;

    public FilaPrioridade() {
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
    boolean enqueuePrioridade(Tipo valor,int prioridade) {
        NodeFilas<Tipo> novo = new NodeFilas<>(valor,prioridade); 
        if (tamanho == 0) {
            this.head = novo;
            this.tail = novo;
        } else {
            NodeFilas<Tipo> atual = this.head;
            while(atual.prox != null && novo.prioridade > atual.prox.prioridade){
                atual = atual.prox;
            }
            if (atual == this.head && novo.prioridade <= atual.prioridade) {
                novo.prox = this.head;
                this.head = novo;
            }else if(atual == this.tail){
                atual.prox = novo;
                this.tail = novo;
            }else{
                novo.prox = atual.prox;
                atual.prox = novo;
            }
        }
        tamanho++;
        return true;
    }

    void imprimir() {
        NodeFilas<Tipo> atual = this.head;
        for (int i = this.tamanho; i > 0; i--) {
            if (i == 1) {
                System.out.print(atual.valor);
                atual = atual.prox;
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
        if(this.tail == null){
            this.head = null;
        }
        return elemento;
    }

    public static void main(String[] args) {
        FilaPrioridade<Integer> fila = new FilaPrioridade<>();
        fila.enqueuePrioridade(0, 10);
        fila.enqueuePrioridade(1, 11);
        fila.enqueuePrioridade(1, 1);
        fila.enqueuePrioridade(2, 11);
        fila.enqueuePrioridade(5, 15);
        fila.enqueue(1);
        fila.imprimir();
        fila.dequeue();
        fila.imprimir();
    }
}

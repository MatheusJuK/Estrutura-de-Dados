package Fila;

public class FilaPrioridade<Tipo> {
    public NodeFilas<Tipo> head, tail;
    public int tamanho;

    public FilaPrioridade() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean enqueue(Tipo valor) {
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
    public boolean enqueuePrioridade(Tipo valor,int prioridade) {
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

    public void imprimir() {
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
    public void imprimirMaiores(int N) {
        FilaPrioridade<Tipo> filaMaiores = new FilaPrioridade<>();
        NodeFilas<Tipo> atual = this.head;
        for (int i = this.tamanho; i > 0; i--) {
            filaMaiores.enqueuePrioridade(atual.valor, i);
            atual = atual.prox;
        }
        NodeFilas<Tipo> atual2 = filaMaiores.head;
        for (int i = 0; i < N; i++) {
            System.out.print(atual2.valor + " -> ");
            atual2 = atual2.prox;
        }
        System.out.println();
    }

    public NodeFilas<Tipo> dequeue() {
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

public class Fila {
    Node head, tail;
    int tamanho;

    Fila() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    boolean enqueue(int valor) {
        Node novo = new Node(valor);
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
        Node atual = this.head;
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

    Node dequeue() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na fila");
            return null;
        }
        Node elemento;

        if (this.head == this.tail) {
            elemento = this.head;
            this.head = null;
            this.tail = null;
        } else {
            Node atual = this.head;
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
        Fila fila1 = new Fila();
        fila1.enqueue(5);
        fila1.enqueue(10);
        fila1.imprimir();
        fila1.dequeue();
        fila1.imprimir();
    }
}

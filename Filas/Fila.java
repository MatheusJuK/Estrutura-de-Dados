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

    void imprimir(Fila fila) {
        Node atual = fila.head;
        for (int i = fila.tamanho; i > 0; i--) {
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
        if(this.tail == null){
            this.head = null;
        }
        return elemento;
    }

    public static void main(String[] args) {
        Fila fila1 = new Fila();
        fila1.imprimir(fila1);
        fila1.enqueue(5);
        fila1.enqueue(10);
        fila1.enqueue(15);
        fila1.enqueue(20);
        fila1.enqueue(25);
        fila1.enqueue(30);
        fila1.enqueue(35);
        fila1.enqueue(40);
        fila1.enqueue(45);
        fila1.imprimir(fila1);
        fila1.dequeue();
        fila1.dequeue();
        fila1.dequeue();
        fila1.dequeue();
        fila1.dequeue();
        fila1.dequeue();
        fila1.dequeue();
        fila1.imprimir(fila1);
    }
}

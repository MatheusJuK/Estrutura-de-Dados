public class Deque {
    Node head, tail;
    int tamanho;

    Deque() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    boolean enqueueLeft(int valor) {
        Node novo = new Node(valor);
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
    boolean enqueueRight(int valor) {
        Node novo = new Node(valor);
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

    void imprimir() {
        Node atual = this.head;
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

    Node dequeueLeft() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na deque");
        }
        Node elemento;
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
    Node dequeueRight() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na deque");
        }
        Node elemento;
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

    public static void main(String[] args) {
        Deque deque1 = new Deque();
        deque1.imprimir();
        deque1.enqueueLeft(5);
        deque1.enqueueLeft(10);
        deque1.enqueueLeft(15);
        deque1.enqueueLeft(20);
        deque1.enqueueLeft(25);
        deque1.enqueueLeft(30);
        deque1.enqueueLeft(35);
        deque1.enqueueLeft(40);
        deque1.enqueueLeft(45);
        deque1.imprimir();
        deque1.dequeueLeft();
        deque1.dequeueLeft();
        deque1.dequeueLeft();
        deque1.dequeueLeft();
        deque1.dequeueLeft();
        deque1.dequeueLeft();
        deque1.imprimir();
    }
}

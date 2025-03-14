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
            this.tail = novo;
            novo.ant = tail.ant;
        }
        tamanho++;
        return true;
    }

    void imprimir(Deque deque) {
        Node atual = deque.head;
        for (int i = deque.tamanho; i > 0; i--) {
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

    boolean remover(int lado) {
        if (tamanho == 0) {
            System.out.println("Não há elementos na deque");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else if (lado ==  0) {
            head = head.prox;
        }else{
            tail = null;
        }
        tamanho--;
        return true;
    }

    public static void main(String[] args) {
        Deque deque1 = new Deque();
        deque1.imprimir(deque1);
        deque1.enqueueLeft(5);
        deque1.enqueueLeft(10);
        deque1.enqueueLeft(15);
        deque1.enqueueLeft(20);
        deque1.enqueueLeft(25);
        deque1.enqueueLeft(30);
        deque1.enqueueLeft(35);
        deque1.enqueueLeft(40);
        deque1.enqueueLeft(45);
        deque1.imprimir(deque1);
        deque1.remover(0);
        deque1.remover(1);
        deque1.remover(0);
        deque1.remover(0);
        deque1.remover(0);
        deque1.remover(0);
        deque1.remover(0);
        deque1.imprimir(deque1);
    }
}

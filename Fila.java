public class Fila {
    Node head, tail;
    int tamanho;

    Fila() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    boolean add(int valor) {
        Node novo = new Node(valor);
        if (tamanho == 0) {
            head = novo;
            tail = novo;
        } else {
            Node antigo = head;
            head = novo;
            head.prox = antigo;
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

    boolean remover() {
        if (tamanho == 0) {
            System.out.println("Não há elementos na fila");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = null;
        }
        tamanho--;
        return true;
    }

    public static void main(String[] args) {
        Fila fila1 = new Fila();
        fila1.imprimir(fila1);
        fila1.add(5);
        fila1.add(10);
        fila1.add(15);
        fila1.add(20);
        fila1.add(25);
        fila1.add(30);
        fila1.add(35);
        fila1.add(40);
        fila1.add(45);
        fila1.imprimir(fila1);
        fila1.remover();
        fila1.remover();
        fila1.remover();
        fila1.remover();
        fila1.remover();
        fila1.remover();
        fila1.remover();
        fila1.imprimir(fila1);
    }
}

public class FilaPrioridade {
    Node head, tail;
    int tamanho;

    FilaPrioridade() {
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
    boolean enqueuePrioridade(int valor,int prioridade) {
        Node novo = new Node(valor,prioridade);
        if (tamanho == 0) {
            this.head = novo;
            this.tail = novo;
        } else {
            Node atual = this.head;
            while(atual.prox != null && novo.prioridade > atual.prox.prioridade){
                atual = atual.prox;
            }
            if(atual.prox == null){
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
        Node atual = this.head;
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
        FilaPrioridade fila1 = new FilaPrioridade();
        fila1.enqueue(0);
        fila1.enqueue(1);
        fila1.enqueue(2);
        fila1.enqueuePrioridade(3,1);
        fila1.enqueuePrioridade(4,1);
        fila1.enqueuePrioridade(5,2);
        fila1.imprimir();
        fila1.dequeue();
        fila1.dequeue();
        fila1.imprimir();
        
    }
}

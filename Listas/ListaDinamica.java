public class ListaDinamica {
    Node head;
    int tamanho;

    ListaDinamica(){
        this.head = null;
        this.tamanho = 0;
    }

    boolean add(int valor, int pos){
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        Node novo = new Node(valor);
        if (pos == 0) {
            novo.prox = this.head;
            this.head = novo;
        }else{
            Node atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }
    public void imprimir() {
        Node atual = this.head;
        System.out.print("head -> ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
    }

    public Node remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        Node removido;
        if (pos == 0) {
            removido = this.head;
            this.head = removido.prox;
            removido.prox = null;
            tamanho--;
            return removido;
        } else {
            Node atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
            removido.prox = null;
            tamanho--;
            return removido;
        }
    }
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.add(0, 0);
        lista.add(1, 1);
        lista.add(2, 2);
        lista.add(3, 0);
        lista.imprimir();
        lista.remover(1);
        lista.imprimir();
    }
}
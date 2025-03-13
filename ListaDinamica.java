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
            novo.prox = head;
            head = novo;
        }else{
            Node atual = head;
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
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
    }

    public boolean remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return false;
        }
        if (pos == 0) {
            head = head.prox;
        } else {
            Node atual = head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            atual.prox = atual.prox.prox;
        }
        tamanho--;
        return true;
    }
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.add(0, 0);
        lista.add(1, 1);
        lista.add(2, 2);
        lista.imprimir();
        lista.remover(1);
        lista.imprimir();
    }
}
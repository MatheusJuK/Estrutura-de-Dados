public class ListaDinamica<Tipo> {
    Node<Tipo> head;
    int tamanho;

    ListaDinamica(){
        this.head = null;
        this.tamanho = 0;
    }

    boolean add(Tipo valor, int pos){
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        Node<Tipo> novo = new Node<Tipo>(valor);
        if (pos == 0) {
            novo.prox = this.head;
            this.head = novo;
        }else{
            Node<Tipo> atual = this.head;
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
        Node<Tipo> atual = this.head;
        System.out.print("head -> ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
    }

    public Node<Tipo> remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        Node<Tipo> removido;
        if (pos == 0) {
            removido = this.head;
            this.head = removido.prox;
            removido.prox = null;
            tamanho--;
            return removido;
        } else {
            Node<Tipo> atual = this.head;
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
        ListaDinamica<Integer> lista = new ListaDinamica<Integer>();
        lista.add(0, 0);
        lista.add(1, 1);
        lista.add(2, 2);
        lista.add(3, 0);
        lista.imprimir();
        lista.remover(1);
        lista.imprimir();
    }
}
package Lista;
public class ListaDuplamenteLigada<Tipo> {
    NodeListas<Tipo> head,tail;
    int tamanho;

    public ListaDuplamenteLigada(){
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    boolean add(Tipo valor, int pos){
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        NodeListas<Tipo> novo = new NodeListas<>(valor);

        if(pos == 0) {
            if (this.head == null) {
                this.head = novo;
                this.tail = novo;
            }else{
                novo.prox = this.head;
                this.head.ant = novo;
                this.head = novo;
            }
        }else if (pos == tamanho) { 
            novo.ant = this.tail;
            this.tail.prox = novo;
            this.tail = novo;
        }else{
            NodeListas<Tipo> atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            novo.ant = atual;
            atual.prox.ant = novo;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }
    public void imprimir() {
        NodeListas<Tipo> atual = this.head;
        NodeListas<Tipo> atual2 = this.tail;
        System.out.print("head -> ");

        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
        System.out.print("tail -> ");
        for (int i = tamanho - 1; i >= 0; i--) {
            System.out.print(atual2.valor + " -> ");
            atual2 = atual2.ant;
        }
        System.out.println("null");

    }

    public NodeListas<Tipo> remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        NodeListas<Tipo> removido;
        if (pos == 0) {
            removido = this.head;
            if (tamanho == 1) {
                this.head = null;
                this.tail = null;
            }else{
                this.head = removido.prox;
                removido.prox = null;
                this.head.ant = null;
            }
        }else if (pos == tamanho - 1) {
            removido = this.tail;
            this.tail = removido.ant;
            this.tail.prox = null;
            removido.ant = null;
        }
        else {
            NodeListas<Tipo> atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
            removido.prox.ant = removido.ant;
            removido.ant = null;
            removido.prox = null;
        }
        tamanho--;
        return removido;
    }
    public static void main(String[] args) {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.add(0,0);
        lista.add(1,1);
        lista.add(2,2);
        lista.add(3,3);
        lista.add(4,4);
        lista.add(5,5);
        lista.imprimir();
        System.out.println(lista.remover(5).valor + " foi removido da lista");
        System.out.println(lista.remover(4).valor + " foi removido da lista");
        System.out.println(lista.remover(3).valor + " foi removido da lista");
        // System.out.println(lista.remover(2).valor + " foi removido da lista");
        // System.out.println(lista.remover(1).valor + " foi removido da lista");
        lista.imprimir();
    }
}
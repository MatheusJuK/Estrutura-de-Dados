package Lista;
public class ListaDuplamenteLigadaCircular<Tipo> {
    public NodeListas<Tipo> head;
    public NodeListas<Tipo> tail;
    public int tamanho;

    public ListaDuplamenteLigadaCircular(){
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean add(Tipo valor, int pos){
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        NodeListas<Tipo> novo = new NodeListas<>(valor);
        if (tamanho == 0) {
            this.head = novo;
            this.tail = novo;
            novo.prox = this.head;
            novo.ant = this.tail;
        }
        else if(pos == 0){
            novo.prox = this.head;
            novo.ant = this.tail;
            this.head.ant = novo;
            this.tail.prox = novo;
            this.head = novo;
        }else if (pos == tamanho) {
            novo.ant = this.tail;
            this.tail.prox = novo;
            this.tail = novo;
            this.head.ant = this.tail;
            this.tail.prox = this.head;
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
    public void imprimir(){
        NodeListas<Tipo> atual = this.head;
        NodeListas<Tipo> atual2 = this.head;
        System.out.print(this.head + " -> ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println(this.head);
        System.out.print(this.tail + " <- ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(atual2.valor + " <- ");
            atual2 = atual2.prox;
        }
        System.out.println(this.tail);
    }
    public NodeListas<Tipo> remover(int pos){
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        NodeListas<Tipo> removido = this.head;
        if (pos == 0 && tamanho == 1) {
            this.head = null;
            this.tail = null;
        }else if (pos == 0) {
            this.head = head.prox;
            this.head.ant = this.tail;
            removido.prox = null;
            removido.ant = null;
            this.tail.prox = this.head;
        }else{
            NodeListas<Tipo> atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            removido.prox.ant = atual;
            atual.prox = removido.prox;
            if (removido.prox == head) {
                this.tail = this.tail.ant;
            }
            removido.ant = null;
            removido.prox = null;
            this.tail.prox = this.head;
            this.head.ant = this.tail;
        }
        tamanho--;
        return removido;
    }
    public void deslocar(NodeListas<Tipo> inicio,NodeListas<Tipo> fim){
        NodeListas<Tipo> atual = this.head;
        while (atual.prox != inicio) {
            atual = atual.prox;
        }
        while (inicio != fim) {
            NodeListas<Tipo> elemento = atual.prox;
            atual.prox = elemento.prox;
            elemento.prox = this.head;
            this.tail.prox = elemento;
            elemento.ant = this.tail;
            atual.prox.ant = atual;
            this.tail = elemento;
            this.head.ant = elemento;
            inicio = atual.prox;
        }
        if (inicio == fim) {
            NodeListas<Tipo> elemento = atual.prox;
            atual.prox = elemento.prox;
            elemento.prox = this.head;
            this.tail.prox = elemento;
            elemento.ant = this.tail;
            atual.prox.ant = atual;
            this.tail = elemento;
            this.head.ant = elemento;
        }
    }
    public static void main(String[] args) {
        ListaDuplamenteLigadaCircular<Integer> lista = new ListaDuplamenteLigadaCircular<>();
        lista.add(0,0);
        lista.add(1,1);
        lista.add(2,2);
        lista.add(3,3);
        lista.add(4,4);
        lista.add(5,5);
        lista.imprimir();
        lista.remover(5);
        lista.remover(4);
        lista.remover(3);
        lista.remover(2);
        lista.remover(1);
        lista.imprimir();
    }
}

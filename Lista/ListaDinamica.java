package Lista;
public class ListaDinamica<Tipo> {
    NodeListas<Tipo> head;
    int tamanho;

    public ListaDinamica(){
        this.head = null;
        this.tamanho = 0;
    }

    public boolean add(Tipo valor, int pos){
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        NodeListas<Tipo> novo = new NodeListas<>(valor);
        if (pos == 0) {
            novo.prox = this.head;
            this.head = novo;
        }else{
            NodeListas<Tipo> atual = this.head;
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
        NodeListas<Tipo> atual = this.head;
        System.out.print("head -> ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
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
            this.head = removido.prox;
            removido.prox = null;
            tamanho--;
            return removido;
        } else {
            NodeListas<Tipo> atual = this.head;
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

    public void verificarParidade(NodeListas<Tipo> atual,NodeListas<Tipo> tail){
        if ((Integer)atual.valor % 2 == 0 && atual == this.head) {
            NodeListas<Tipo> atual2 = this.head;
            while (atual2.prox != null) {
                atual2 = atual2.prox;
            }
            atual2.prox = atual;
            this.head = atual.prox;
            atual.prox = null;
        }else if ((Integer)atual.prox.valor % 2 == 0) {
            NodeListas<Tipo> atual2 = this.head;
            while (atual2.prox != null) {
                atual2 = atual2.prox;
            }
            if (atual.prox != atual2) {
                atual2.prox = atual.prox;
                atual.prox = atual.prox.prox;
                atual2.prox.prox = null;
            }
        }
        else{
            verificarParidade(atual.prox, tail);
        }
    }
    public void ordenarLista(){
        NodeListas<Tipo> tail = this.head;
        while(tail.prox != null) {
            tail = tail.prox;
        }
        for(int i = 0; i < this.tamanho + 1; i++){
            NodeListas<Tipo> atual = this.head;
            verificarParidade(atual, tail);
        }
    }
    public static void main(String[] args) {
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        lista.add(0, 0);
        lista.add(1, 1);
        lista.add(2, 2);
        lista.add(3, 0);
        lista.imprimir();
        lista.remover(1);
        lista.imprimir();
    }
}
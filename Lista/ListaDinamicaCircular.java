package Lista;
public class ListaDinamicaCircular<Tipo> {
    NodeListas<Tipo> head;
    int tamanho;
    int i = 0;
    public ListaDinamicaCircular(){
        this.head = null;
        this.tamanho = 0;
    }

    boolean add(Tipo valor, int pos){
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        NodeListas<Tipo> novo = new NodeListas<>(valor);
        if (pos == 0) {
            if (tamanho == 0) {
                this.head = novo;
                novo.prox = this.head;
            }
            else{
                NodeListas<Tipo> atual = this.head;
                while (atual.prox != this.head) {
                    atual = atual.prox;
                }
                novo.prox = this.head;
                this.head = novo;
                atual.prox = this.head;
            }
        }
        else{
            NodeListas<Tipo> atual = this.head;
            while (i < pos - 1) {
                atual = atual.prox;
                i++;
            }
            // for (int i = 0; i < pos - 1; i++){
            //     atual = atual.prox;
            // }
            novo.prox = atual.prox;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }
    public void imprimir() {
        NodeListas<Tipo> atual = head;
        System.out.print("head -> ");

        for(int i = 0; i < tamanho;i++){
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("head");

    }

    public NodeListas<Tipo> remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        NodeListas<Tipo> removido;
        if (tamanho == 1) {
            removido = this.head;
            removido.prox = null;
            this.head = null;
        }else if(pos == 0){
            NodeListas<Tipo> atual = this.head;
            while (atual.prox != this.head) {
                atual = atual.prox;
            }
            removido = this.head;
            this.head = head.prox;
            atual.prox = this.head;
            removido.prox = null; 
        }else {
            NodeListas<Tipo> atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
            removido.prox = null;
        }
        tamanho--;
        return removido;
    }
    public static void main(String[] args) {
        ListaDinamicaCircular<Integer> lista = new ListaDinamicaCircular<>();
        lista.add(0, 0);
        lista.imprimir();
        lista.remover(0);
        lista.imprimir();
    }
}

package Lista;
public class ListaDinamica<Tipo> {
    NodeListas<Tipo> head;
    public int tamanho;

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

    public void verificarParidade(NodeListas<Tipo> atual){
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
            verificarParidade(atual.prox);
        }
    }
    public void ordenarLista(){
        NodeListas<Tipo> atual3 = this.head;
        int contPares = 0;
        while(atual3.prox != null) {
            if (atual3.prox.prox == null && (Integer) atual3.prox.valor % 2  == 0) {
                contPares++;
            }
            else if ((Integer) atual3.valor % 2 == 0) {
                contPares++;
            }
            atual3 = atual3.prox;
        }
        for(int i = 0; i < contPares + 1; i++){
            NodeListas<Tipo> atual = this.head;
            verificarParidade(atual);
        }
    }
    public boolean ordenarMenoresQueX(int x){
        if (this.head == null) {
            return false;
        }
        NodeListas<Tipo> atual = this.head;
        while (atual.prox != null) {
            NodeListas<Tipo> elemento;
            if ((Integer)atual.prox.valor < x){
                elemento = atual.prox;
                if (atual == this.head && atual.prox.prox != null) {
                    this.head = atual.prox;
                    atual.prox = elemento.prox;
                    elemento.prox = atual;
                }else if (atual == this.head) {
                    elemento.prox = this.head;
                    this.head = atual.prox;
                    atual.prox = null;
                }
                else if (atual.prox.prox == null) {
                    atual.prox.prox = this.head;
                    this.head = atual.prox;
                    atual.prox = null;
                }else{
                    atual.prox = elemento.prox;
                    elemento.prox = this.head;
                    this.head = elemento;
                }
            }else{
                atual = atual.prox;
            }
            
        }
        return true;
    }
    public boolean justarListasOrdenadas(ListaDinamica<Integer> lista1, ListaDinamica<Integer> lista2, ListaDinamica<Integer> lista){
        if (lista1.head == null && lista2.head == null || lista1.head == null || lista2.head == null) {
            return false;
        }
        lista.add(0, 0);//inserir dado facilitador
        NodeListas<Integer> atual = lista.head;
        NodeListas<Integer> atual1 = lista1.head;
        NodeListas<Integer> atual2 = lista2.head;
        while (atual1 != null && atual2 != null) {
            if (atual1.valor < atual2.valor) {
                atual.prox = atual1;
                atual1 = atual1.prox;
            }else{
                atual.prox = atual2;
                atual2 = atual2.prox;
            }
            atual = atual.prox;
        }
        if (atual1 != null) {
            atual.prox = atual1;
        }else if(atual2 != null){
            atual.prox = atual2;
        }
        lista.remover(0);//remover o dado facilitador
        return true;
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
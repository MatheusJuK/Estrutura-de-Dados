package Lista;
public class ListaDuplamenteLigada<Tipo> {
    NodeListas<Tipo> head,tail;
    public int tamanho;

    public ListaDuplamenteLigada(){
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean add(Tipo valor, int pos){
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
    public boolean inverterSegmento(int indicei, int indicej){
        if (this.head == null || indicei > tamanho || indicej > tamanho || indicej < indicei) {
            return false;
        }
        NodeListas<Tipo> atuali = this.head;
        NodeListas<Tipo> atualj = this.head;
        for (int i = 0; i < indicei; i++) {
            atuali = atuali.prox;
        }
        for (int j = 0; j < indicej; j++) {
            atualj = atualj.prox;
        }
        NodeListas<Tipo> alterado = atuali;
        while (atuali != atualj) {
            alterado = atuali;
            atuali = atuali.prox;
            alterado.prox.ant = alterado.ant;
            alterado.ant.prox = alterado.prox;
            if (atualj.prox != null) {
                alterado.prox = atualj.prox;
                alterado.prox.ant = alterado;
            }else{
                alterado.prox = null;
                this.tail = alterado;
            }
            alterado.ant = atualj;
            atualj.prox = alterado;
        }
        return true;
    }

    public boolean juntarListasOrdenadas(ListaDuplamenteLigada<Integer> lista1,ListaDuplamenteLigada<Integer> lista2,ListaDuplamenteLigada<Integer> lista){
        if (lista1.head == null && lista2.head == null) {
            return false;
        }
        if (lista1.head == null) {
            lista.head = lista2.head;
            lista.tail = lista2.tail;
            lista.tamanho = lista2.tamanho;
            return true;
        }
        if (lista2.head == null) {
            lista.head = lista1.head;
            lista.tail = lista1.tail;
            lista.tamanho = lista1.tamanho;
            return true;
        }
        NodeListas<Integer> atual1 = lista1.head;
        NodeListas<Integer> atual2 = lista2.head;

        if (atual1.valor < atual2.valor) {
            lista.head = atual1;
            lista.tail = atual1;
            atual1 = atual1.prox;
            lista.tamanho++;
        } else {
            lista.head = atual2;
            lista.tail = atual2;
            atual2 = atual2.prox;
            lista.tamanho++;
        }
        NodeListas<Integer> atual = lista.head;
        while (atual1 != null && atual2 != null) {
            if (atual1.valor < atual2.valor){
                atual.prox = atual1;
                atual1.ant = atual;
                lista.tail = atual1;
                atual1 = atual1.prox;
            }else{
                atual.prox = atual2;
                atual2.ant = atual;
                lista.tail = atual2;
                atual2 = atual2.prox;
            }
            atual = atual.prox;
            lista.tamanho++;
        }
        int cont = 0;
        if (atual1 != null) {
            atual.prox = atual1;
            atual1.ant = atual;
            while (atual1 != null) {
                cont++;
                if (atual1.prox != null) {
                    atual1 = atual1.prox;
                }else{
                    break;
                }
            }
            lista.tail = atual1; 
        }
        else if(atual2 != null){
            atual.prox = atual2;
            atual2.ant = atual;
            while (atual2 != null) {
                cont++;
                if (atual2.prox != null) {
                    atual2 = atual2.prox;
                }else{
                    break;
                }
            }
            lista.tail = atual2; 
        }
        lista.tamanho += cont;

        return true;
    }
    public void inverter(){
        NodeListas<Tipo> ultimoOrdenado = this.head;
        for(int i = 0; i < this.tamanho - 1;i++){
            if (i == 0) {
                NodeListas<Tipo> novoTail = this.head;
                this.tail.prox = novoTail;
                novoTail.ant = this.tail;
                this.head = this.head.prox;
                novoTail.prox = null;
                this.head.ant = null;
                this.tail = ultimoOrdenado;
                ultimoOrdenado = novoTail;
            }else{
                NodeListas<Tipo> elemento = this.head;
                NodeListas<Tipo> atual = this.head;
                while (atual.prox != ultimoOrdenado) {
                    atual = atual.prox;
                }
                this.head = this.head.prox;
                elemento.prox = ultimoOrdenado;
                elemento.ant = atual;
                ultimoOrdenado.ant = elemento;
                atual.prox = elemento;
                this.head.ant = null;
                ultimoOrdenado = elemento;
            }
        }
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
        lista.inverter();
        lista.imprimir();
    }
}
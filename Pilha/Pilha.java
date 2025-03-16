public class Pilha{
    int tamanho;
    Node topo;

    Pilha(){
        this.tamanho = 0;
        this.topo = null;
    }
    boolean isEmpty(){
        return (this.tamanho == 0);
    }
    boolean push(int valor){
        Node novo = new Node(valor);
        if (this.isEmpty()) {
            this.topo = novo;
        }else{
            novo.prox = this.topo;
            this.topo = novo;
        }
        tamanho++;
        return true;
    }
    Node pop(){
        if (this.isEmpty()) {
            return null;
        }else{
            Node removido = this.topo;
            this.topo = this.topo.prox;
            removido.prox = null;
            tamanho--;
            return removido;
        }
    }
    Node peek(){
        System.out.println(this.topo.valor + " está no topo");
        return this.topo;
    }
    public void imprimir(){
        Node atual = this.topo;
        while (atual.prox != null) {
            if (atual == this.topo) {
                System.out.println(atual.valor + " <- topo");
            }
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        pilha.push(0);
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        pilha.push(6);
        pilha.push(7);
        pilha.push(8);
        pilha.push(9);
        pilha.peek();
        pilha.imprimir();
        pilha.pop();
        pilha.peek();
        pilha.imprimir();
    }
}
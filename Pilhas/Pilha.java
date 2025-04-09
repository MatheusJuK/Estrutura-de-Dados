package Pilhas;

public class Pilha<Tipo>{
    public int tamanho;
    public NodePilha<Tipo> topo;

    public Pilha(){
        this.tamanho = 0;
        this.topo = null;
    }
    public boolean isEmpty(){
        return (this.tamanho == 0);
    }
    public boolean push(Tipo valor){
        NodePilha<Tipo> novo = new NodePilha<>(valor);
        if (this.isEmpty()) {
            this.topo = novo;
        }else{
            novo.prox = this.topo;
            this.topo = novo;
        }
        tamanho++;
        return true;
    }
    public Tipo pop(){
        if (this.isEmpty()) {
            return null;
        }else{
            NodePilha<Tipo> removido = this.topo;
            this.topo = this.topo.prox;
            removido.prox = null;
            tamanho--;
            return removido.valor;
        }
    }
    public NodePilha<Tipo> peek(){
        System.out.println(this.topo.valor + " está no topo");
        return this.topo;
    }
    public void imprimir(){
        NodePilha<Tipo> atual = this.topo;
        while (atual.prox != null) {
            if (atual == this.topo) {
                System.out.println(atual.valor + " <- topo");
            }else{
                System.out.println(atual.valor);
            }
            atual = atual.prox;
        }
    }
    public Tipo get(int i){
        if (i < 0 || i >= this.tamanho) {
            return null;
        }else{
            NodePilha<Tipo> atual = this.topo;
            for (int j = 0; j < i; j++) {
                atual = atual.prox;
            }
            return atual.valor;
        }
    }
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<>();
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
package Arvores;

public class NodeArvore<Tipo extends Comparable>{
    Tipo valor;
    NodeArvore<Tipo> direita;
    NodeArvore<Tipo> esquerda;
    public NodeArvore(Tipo valor){
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }
}


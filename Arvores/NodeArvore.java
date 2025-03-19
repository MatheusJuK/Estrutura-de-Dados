package Arvores;

public class NodeArvore<Tipo> {
    Tipo valor;
    NodeArvore<Tipo> direita;
    NodeArvore<Tipo> esquerda;
    public NodeArvore(Tipo valor){
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }
}


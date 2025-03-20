package Arvores;

@SuppressWarnings("rawtypes")
public class Arvore<Tipo extends Comparable> {
    NodeArvore<Tipo> raiz;

    public Arvore() {
        this.raiz = null;
    }

    @SuppressWarnings("unchecked")
    public boolean add(Tipo valor){
        NodeArvore<Tipo> novo = new NodeArvore<>(valor);
        if (this.raiz == null) {
            this.raiz = novo;
            return true;
        }

        NodeArvore<Tipo> atual = this.raiz;
        while(true) {
            if (novo.valor.compareTo(atual.valor) == -1) {
                if (atual.esquerda == null) {
                    atual.esquerda = novo;
                    return true;
                }else{
                    atual = atual.esquerda;
                }
            }else{
                if (atual.direita == null) {
                    atual.direita = novo;
                    return true;
                }else{
                    atual = atual.direita;
                }
            }
        }
    }
    
    public void EmOrdem(NodeArvore<Tipo> atual){
        if (atual != null) {
            EmOrdem(atual.esquerda);
            System.out.println(atual.valor);
            EmOrdem(atual.direita);
        }
    }
    public void PreOrdem(NodeArvore<Tipo> atual){
        if (atual != null) {
            System.out.println(atual.valor);
            EmOrdem(atual.esquerda);
            EmOrdem(atual.direita);
        }
    }
    public void PosOrdem(NodeArvore<Tipo> atual){
        if (atual != null) {
            EmOrdem(atual.esquerda);
            EmOrdem(atual.direita);
            System.out.println(atual.valor);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void herdarFilhos(NodeArvore<Tipo> atual, NodeArvore<Tipo> paiAtual, NodeArvore<Tipo> substituto){
        if (paiAtual != null) {
            if (atual.valor.compareTo(paiAtual.valor) == -1) {
                if (atual.direita == substituto) {
                    substituto.esquerda = atual.esquerda;
                    paiAtual.esquerda = substituto;
                }else if (atual.esquerda == substituto) {
                    substituto.direita = atual.direita;
                    paiAtual.esquerda = substituto;
                }else{
                    substituto.esquerda = atual.esquerda;
                    substituto.direita = atual.direita;
                    paiAtual.esquerda = substituto;
                }
            }else{
                if (atual.direita == substituto) {
                    substituto.esquerda = atual.esquerda;
                    paiAtual.direita = substituto;
                }else if (atual.esquerda == substituto) {
                    substituto.direita = atual.direita;
                    paiAtual.direita = substituto;
                }else{
                    substituto.esquerda = atual.esquerda;
                    substituto.direita = atual.direita;
                    paiAtual.direita = substituto;
                }
            }
        }else{
            if (this.raiz.direita == substituto) {
                substituto.esquerda = this.raiz.esquerda;
                this.raiz = substituto;
            }else if (this.raiz.esquerda == substituto) {
                substituto.direita = atual.direita;
                this.raiz = substituto;
            }else{
                substituto.esquerda = atual.esquerda;
                substituto.direita = atual.direita;
                this.raiz = substituto;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public void matarLigacaoSubstituto(NodeArvore<Tipo> substituto, NodeArvore<Tipo> paiSubstituto){
        if (substituto.valor.compareTo(paiSubstituto.valor) == -1) {
            if (paiSubstituto == this.raiz) {
                paiSubstituto.esquerda = null;
                paiSubstituto.direita = null;
            }else{
                paiSubstituto.esquerda = null;
            }
        }else{
            if (paiSubstituto == this.raiz) {
                paiSubstituto.esquerda = null;
                paiSubstituto.direita = null;
            }else{
                paiSubstituto.direita = null;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public NodeArvore<Tipo> remover(Tipo valor){
        NodeArvore<Tipo> atual = this.raiz;
        NodeArvore<Tipo> paiAtual = null;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                break;
            }else if (valor.compareTo(atual.valor) == -1) {
                paiAtual = atual;
                atual = atual.esquerda;
            }else{
                paiAtual = atual;
                atual = atual.direita;
            }
        }
        if(atual != null){
            NodeArvore<Tipo> removido = atual;
            if (atual.direita != null) {
                NodeArvore<Tipo> substituto = atual.direita;
                NodeArvore<Tipo> paiSubstituto = atual;
                while (substituto.esquerda != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.esquerda;
                }
                herdarFilhos(atual, paiAtual, substituto);
                matarLigacaoSubstituto(substituto, paiSubstituto);
            }else if (atual.esquerda != null) {
                NodeArvore<Tipo> substituto = atual.esquerda;
                NodeArvore<Tipo> paiSubstituto = atual;
                while (substituto.direita != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.direita;
                }
                herdarFilhos(atual, paiAtual, substituto);
                matarLigacaoSubstituto(substituto, paiSubstituto);
            }else{
                if (paiAtual != null) {
                    matarLigacaoSubstituto(atual, paiAtual);
                }else{
                    this.raiz = null;
                }
            }
            return removido;
        }else{
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public void busca(Tipo valor){
        NodeArvore<Tipo> buscado = null;
        NodeArvore<Tipo> atual = this.raiz;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                buscado = atual;
                break;
            }else if(valor.compareTo(atual.valor) == -1){
                atual = atual.esquerda;
            }else{
                atual = atual.direita;
            }
        }
        if (buscado == null) {
            System.out.println("Elemento não encontrado");
        }else{
            System.out.println(buscado.valor + " foi encontrado");
        }
    }
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();
        arvore.add(10);
        arvore.add(6);
        arvore.add(8);
        arvore.add(9);
        arvore.add(7);
        arvore.add(4);
        arvore.add(5);
        arvore.add(2);
        arvore.add(15);
        arvore.add(20);
        arvore.add(17);
        arvore.add(22);
        arvore.remover(7);
        arvore.remover(10);
        arvore.remover(22);
        arvore.remover(5);
        arvore.remover(2);
        arvore.remover(6);
        arvore.remover(17);
        arvore.remover(9);
        arvore.remover(4);
        arvore.remover(15);
        arvore.remover(20);
        arvore.remover(8);
        System.out.println("Em-Ordem");
        arvore.EmOrdem(arvore.raiz);
        // System.out.println("Pré-Ordem");
        // arvore.PreOrdem(arvore.raiz);
        // System.out.println("Pós-Ordem");
        // arvore.PosOrdem(arvore.raiz);
        // arvore.remover(22);
        // System.out.println("Em-Ordem");
        // arvore.EmOrdem(arvore.raiz);
    }
}

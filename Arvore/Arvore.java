@SuppressWarnings("rawtypes")
public class Arvore<Tipo extends Comparable> {
    Node<Tipo> raiz;

    public Arvore() {
        this.raiz = null;
    }

    @SuppressWarnings("unchecked")
    public boolean add(Tipo valor){
        Node<Tipo> novo = new Node<>(valor);
        if (this.raiz == null) {
            this.raiz = novo;
            return true;
        }

        Node<Tipo> atual = this.raiz;
        while(true) {
            if (novo.valor.compareTo(atual.valor) == -1) {
                if (atual.ant == null) {
                    atual.ant = novo;
                    return true;
                }else{
                    atual = atual.ant;
                }
            }else{
                if (atual.prox == null) {
                    atual.prox = novo;
                    return true;
                }else{
                    atual = atual.prox;
                }
            }
        }
    }

    public void EmOrdem(Node<Tipo> atual){
        if (atual != null) {
            EmOrdem(atual.ant);
            System.out.println(atual.valor);
            EmOrdem(atual.prox);
        }
    }
    public void PreOrdem(Node<Tipo> atual){
        if (atual != null) {
            System.out.println(atual.valor);
            EmOrdem(atual.ant);
            EmOrdem(atual.prox);
        }
    }
    public void PosOrdem(Node<Tipo> atual){
        if (atual != null) {
            EmOrdem(atual.ant);
            EmOrdem(atual.prox);
            System.out.println(atual.valor);
        }
    }

    @SuppressWarnings("unchecked")
    public Node<Tipo> remover(Tipo valor){
        Node<Tipo> atual = this.raiz;
        Node<Tipo> paiAtual = null;
        Node<Tipo> removido;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                break;
            }else if (valor.compareTo(atual.valor) == -1) {
                paiAtual = atual;
                atual = atual.ant;
            }else{
                paiAtual = atual;
                atual = atual.prox;
            }
        }
        if(atual != null){
            removido = atual;
            if (atual.prox != null) {
                Node<Tipo> substituto = atual.prox;
                Node<Tipo> paiSubstituto = atual;
                while (substituto.ant != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.ant;
                }
                if (paiAtual != null) {
                    if (atual.valor.compareTo(paiAtual.valor) == -1) {
                        if (atual.prox == substituto) {
                            substituto.ant = atual.ant;
                            paiAtual.ant = substituto;
                        }else if (atual.ant == substituto) {
                            substituto.prox = atual.prox;
                            paiAtual.ant = substituto;
                        }else{
                            substituto.ant = atual.ant;
                            substituto.prox = atual.prox;
                            paiAtual.ant = substituto;
                        }
                    }else{
                        if (atual.prox == substituto) {
                            substituto.ant = atual.ant;
                            paiAtual.prox = substituto;
                        }else if (atual.ant == substituto) {
                            substituto.prox = atual.prox;
                            paiAtual.prox = substituto;
                        }else{
                            substituto.ant = atual.ant;
                            substituto.prox = atual.prox;
                            paiAtual.prox = substituto;
                        }
                    }
                }else{
                    if (this.raiz.prox == substituto) {
                        substituto.ant = this.raiz.ant;
                        this.raiz = substituto;
                    }else if (this.raiz.ant == substituto) {
                        substituto.prox = atual.prox;
                        this.raiz = substituto;
                    }else{
                        substituto.ant = atual.ant;
                        substituto.prox = atual.prox;
                        this.raiz = substituto;
                    }
                }
                if (substituto.valor.compareTo(paiSubstituto.valor) == -1) {
                    paiSubstituto.ant = null;
                }else{
                    paiSubstituto.prox = null;
                }
            }else if (atual.ant != null) {
                Node<Tipo> substituto = atual.ant;
                Node<Tipo> paiSubstituto = atual;
                while (substituto.prox != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.prox;
                }
                if (paiAtual != null) {
                    if (atual.valor.compareTo(paiAtual.valor) == -1) {
                        if (atual.prox == substituto) {
                            substituto.ant = atual.ant;
                            paiAtual.ant = substituto;
                        }else if (atual.ant == substituto) {
                            substituto.prox = atual.prox;
                            paiAtual.ant = substituto;
                        }else{
                            substituto.ant = atual.ant;
                            substituto.prox = atual.prox;
                            paiAtual.ant = substituto;
                        }
                    }else{
                        if (atual.prox == substituto) {
                            substituto.ant = atual.ant;
                            paiAtual.prox = substituto;
                        }else if (atual.ant == substituto) {
                            substituto.prox = atual.prox;
                            paiAtual.prox = substituto;
                        }else{
                            substituto.ant = atual.ant;
                            substituto.prox = atual.prox;
                            paiAtual.prox = substituto;
                        }
                    }
                }else{
                    if (this.raiz.prox == substituto) {
                        substituto.ant = this.raiz.ant;
                        this.raiz = substituto;
                    }else if (this.raiz.ant == substituto) {
                        substituto.prox = atual.prox;
                        this.raiz = substituto;
                    }else{
                        substituto.ant = atual.ant;
                        substituto.prox = atual.prox;
                        this.raiz = substituto;
                    }
                }
                if (substituto.valor.compareTo(paiSubstituto.valor) == -1) {
                    paiSubstituto.ant = null;
                }else{
                    paiSubstituto.prox = null;
                }
            }else{
                if (paiAtual != null) {
                    if (atual.valor.compareTo(paiAtual.valor) == -1) {
                        paiAtual.ant = null;
                    }else{
                        paiAtual.prox = null;
                    }
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
        Node<Tipo> buscado = null;
        Node<Tipo> atual = this.raiz;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                buscado = atual;
                break;
            }else if(valor.compareTo(atual.valor) == -1){
                atual = atual.ant;
            }else{
                atual = atual.prox;
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
        System.out.println("Em-Ordem");
        arvore.EmOrdem(arvore.raiz);
        // System.out.println("Pré-Ordem");
        // arvore.PreOrdem(arvore.raiz);
        // System.out.println("Pós-Ordem");
        // arvore.PosOrdem(arvore.raiz);
        // arvore.remover(22);
        // System.out.println("Em-Ordem");
        // arvore.EmOrdem(arvore.raiz);
        arvore.busca(10);
    }
}

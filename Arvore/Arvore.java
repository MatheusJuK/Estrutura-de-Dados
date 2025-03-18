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
        }

        Node<Tipo> atual = this.raiz;
        while(true) {
            if (novo.valor.compareTo(atual.valor) == -1) {
                if (atual.esquerda == null) {
                    atual.esquerda = novo;
                    break;
                }else{
                    atual = atual.esquerda;
                }
            }else{
                if (atual.direita == null) {
                    atual.direita = novo;
                    break;
                }else{
                    atual = atual.direita;
                }
            }
        }
        return true;
    }
}

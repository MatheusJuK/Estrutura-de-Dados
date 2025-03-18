public class ListaEstatica<Tipo> {
    int ultimo;
    int tamanho;
    Tipo[] valores;
    @SuppressWarnings("unchecked")
    ListaEstatica(int tamanho){
        this.tamanho = tamanho;
        this.valores = (Tipo[]) new Object[tamanho];
        this.ultimo = -1;
    }
    
    boolean add(Tipo valor, int pos){
        if (pos < 0 || pos > ultimo + 1 || pos > tamanho - 1) {
            return false;
        }
        for (int i = ultimo; i >= pos; i--) {
            valores[i + 1] = valores[i];
        }
        valores[pos] = valor;
        ultimo++;
        return true;
    }
    boolean remove(int pos){
        if (pos < 0 || pos > ultimo) {
            return false;
        }
        for (int i = pos; i < ultimo; i++) {
            valores[i] = valores[i + 1];
        }
        ultimo --;
        return true;
    }

    void imprimir(){
        for (int i = 0; i <= ultimo; i++) {
            System.out.print(valores[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListaEstatica<String> lista = new ListaEstatica<String>(10);
        lista.add("A", 0);
        lista.imprimir();
        lista.add("E", 1);
        lista.add("I", 2);
        lista.add("O", 3);
        lista.add("U", 4);
        lista.imprimir();
    }
}

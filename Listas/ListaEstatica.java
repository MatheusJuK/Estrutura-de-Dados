public class ListaEstatica {
    int ultimo;
    int tamanho;
    int[] valores;
    ListaEstatica(int tamanho){
        this.tamanho = tamanho;
        this.valores = new int[tamanho];
        this.ultimo = -1;
    }
    
    boolean add(int valor, int pos){
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
        ListaEstatica lista = new ListaEstatica(10);
        lista.add(0, 0);
        lista.add(1, 1);
        lista.add(2, 2);
        lista.add(3, 3);
        lista.add(4, 4);
        lista.add(5, 5);
        lista.add(6, 6);
        lista.add(7, 7);
        lista.add(8, 8);
        lista.add(9, 9);
        lista.imprimir();
        lista.imprimir();
    }
}

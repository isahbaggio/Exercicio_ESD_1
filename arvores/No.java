import java.util.ArrayList;
import java.util.List;

public class No<E> implements Posicao<E> {

    String valor;
    private E elemento;
    No<E> pai;
    List<No<E>> filhos = new ArrayList<>();

    No(String valor) {
        this.valor = valor;
        this.filhos = new ArrayList<>();
    }

    public No(E elemento, No<E> pai) {
        this.elemento = elemento;
        this.pai = pai;
    }

    public E getElemento() {
        return elemento;
    }

    public No<E> getPai() {
        return pai;
    }

    public List<No<E>> getFilhos() {
        return filhos;
    }

    public void adicionarFilho(No<E> filho) {
        filhos.add(filho);
        filho.pai = this;
    }

    boolean ehFolha() {
        return filhos.isEmpty();
    }
}

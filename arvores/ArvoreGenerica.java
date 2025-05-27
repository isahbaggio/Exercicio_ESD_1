import java.util.ArrayList;

public class ArvoreGenerica<E> implements Arvore<E> {

    private No<E> raiz;
    private Integer tamanho;

    public ArvoreGenerica() {
        raiz = null;
        tamanho = 0;
    }

    public Posicao<E> adicionarRaiz(E elemento) {
        // TODO
        return raiz;
    }

    public Posicao<E> adicionarFilho(Posicao<E> posicaoPai, E elemento) {
        No<E> pai = validarNo(posicaoPai);
        No<E> filho = new No<>(elemento, pai);
        pai.adicionarFilho(filho);
        tamanho++;
        return filho;
    }

    private No<E> validarNo(Posicao<E> posicao) {
        if (!(posicao instanceof No)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return (No<E>) posicao;
    }

    public void percursoPreOrdem(Posicao<E> posicao) {
        System.out.print(posicao.getElemento() + " ");

        for (Posicao<E> filho : filhos(posicao)) {
            percursoPreOrdem(filho);
        }
    }

    @Override
    public Posicao<E> raiz() {
        return raiz;
    }

    @Override
    public Posicao<E> pai(Posicao<E> posicao) {
        return validarNo(posicao).getPai();
    }

    @Override
    public Iterable<Posicao<E>> filhos(Posicao<E> posicao) {
        return new ArrayList<>(validarNo(posicao).getFilhos());
    }

    @Override
    public Boolean ehFolha(Posicao<E> posicao) {
        // TODO
        return false;
    }

    @Override
    public Boolean temFilhos(Posicao<E> posicao) {
        // TODO
        return false;
    }

    @Override
    public Boolean temPai(Posicao<E> posicao) {
        // TODO
        return false;
    }

    @Override
    public Boolean ehRaiz(Posicao<E> posicao) {
        return posicao == raiz;
    }

    @Override
    public Integer tamanho() {
        return tamanho;
    }

    @Override
    public Boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public Integer altura(Posicao<E> posicao) {
        if (ehFolha(posicao)) return 0;
        Integer altura = 0;
        for (Posicao<E> filho : filhos(posicao)) {
            altura = Math.max(altura, altura(filho));
        }
        return 1 + altura;
    }

    @Override
    public Integer profundidade(Posicao<E> posicao) {
        // TODO
        return 0;
    }
}

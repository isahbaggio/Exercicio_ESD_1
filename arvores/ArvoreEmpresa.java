public class ArvoreEmpresa<E> {
    No<E> raiz;

    // Cadastro da árvore conforme o diagrama
    void cadastrarArvore() {
        raiz = new No<E>("Empresa");

        No<E> rh = new No<E>("RH");
        No<E> recrutamento = new No<E>("Recrutamento");
        No<E> estagios = new No<E>("Estágios");
        recrutamento.adicionarFilho(estagios);
        rh.adicionarFilho(recrutamento);

        No<E> beneficios = new No<E>("Benefícios");
        No<E> convenios = new No<E>("Convênios");
        beneficios.adicionarFilho(convenios);
        rh.adicionarFilho(beneficios);

        No<E> ti = new No<E>("TI");
        No<E> desenvolvimento = new No<E>("Desenvolvimento");
        No<E> frontend = new No<E>("Front-end");
        No<E> angular = new No<E>("Angular");
        frontend.adicionarFilho(angular);
        desenvolvimento.adicionarFilho(frontend);

        No<E> backend = new No<E>("Back-end");
        desenvolvimento.adicionarFilho(backend);
        ti.adicionarFilho(desenvolvimento);

        No<E> suporte = new No<E>("Suporte");
        ti.adicionarFilho(suporte);

        No<E> financeiro = new No<E>("Financeiro");
        No<E> contabilidade = new No<E>("Contabilidade");
        No<E> impostos = new No<E>("Impostos");
        contabilidade.adicionarFilho(impostos);
        financeiro.adicionarFilho(contabilidade);

        raiz.adicionarFilho(rh);
        raiz.adicionarFilho(ti);
        raiz.adicionarFilho(financeiro);
    }

    // Pré-ordem
    void preOrdem(No<E> no) {
        if (no == null) return;
        System.out.println(no.valor);
        for (No<E> filho : no.filhos) {
            preOrdem(filho);
        }
    }

    // Pós-ordem
    void posOrdem(No<E> no) {
        if (no == null) return;
        for (No<E> filho : no.filhos) {
            posOrdem(filho);
        }
        System.out.println(no.valor);
    }

    // Imprime apenas os nós folha
    void imprimirFolhas(No<E> no) {
        if (no == null) return;
        if (no.ehFolha()) {
            System.out.println(no.valor);
        }
        for (No<E> filho : no.filhos) {
            imprimirFolhas(filho);
        }
    }

    // Retorna a profundidade de um nó
    int profundidade(No<E> no){
        int prof = 0;
        while (no.pai != null) {
            prof++;
            no = no.pai;
        }
        return prof;
    }

    // Desenho da árvore (simples, usando indentação)
    void desenhar(No<E> no, String prefixo) {
        System.out.println(prefixo + no.valor);
        for (int i = 0; i < no.filhos.size(); i++) {
            No<E> filho = no.filhos.get(i);
            boolean ehUltimo = (i == no.filhos.size() - 1);
            desenhar(filho, prefixo + (ehUltimo ? "    " : "│   "));
        }
    }

    public static void main(String[] args) {
        ArvoreEmpresa arvore = new ArvoreEmpresa();
        arvore.cadastrarArvore();

        System.out.println("Desenho da árvore:");
        arvore.desenhar(arvore.raiz, "");

        System.out.println("\nPré-ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nPós-ordem:");
        arvore.posOrdem(arvore.raiz);

        System.out.println("\nNós folha:");
        arvore.imprimirFolhas(arvore.raiz);

        // Exemplo de profundidade:
        No angular = (No) arvore.raiz.getFilhos();
        System.out.println("\nProfundidade do nó 'Angular': " + arvore.profundidade(angular));
    }
}

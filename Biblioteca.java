public class Biblioteca {

    private final ItemBiblioteca[] acervo;
    private int quantidadeItens;

    public Biblioteca(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("O tamanho do acervo deve ser maior que zero.");
        }
        acervo = new ItemBiblioteca[tamanho];
        quantidadeItens = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (item == null) {
            System.out.println("Não é possível cadastrar um item nulo.");
            return;
        }

        if (quantidadeItens < acervo.length) {
            acervo[quantidadeItens] = item;
            quantidadeItens++;
            System.out.println("Item cadastrado: " + item.getTitulo());
        } else {
            System.out.println("Acervo cheio! Não foi possível cadastrar " + item.getTitulo());
        }
    }

    public void emprestar(ItemBiblioteca item, Usuario usuario) {
        if (item == null || usuario == null) {
            System.out.println("Item ou usuário inválido.");
            return;
        }

        if (!estaNoAcervo(item)) {
            System.out.println("Item não cadastrado nesta biblioteca.");
            return;
        }

        if (!item.isDisponivel()) {
            System.out.println("Item indisponível para empréstimo.");
            return;
        }

        if (usuario.getQuantidadeEmprestada() >= usuario.limiteItens()) {
            System.out.println("Empréstimo recusado! Limite de itens atingido para " + usuario.getNome());
            return;
        }

        item.emprestar();
        usuario.adicionarEmprestimo();

        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Item: " + item.getTitulo());
    }

    public void devolver(ItemBiblioteca item, Usuario usuario) {
        if (item == null || usuario == null) {
            System.out.println("Item ou usuário inválido.");
            return;
        }

        if (!estaNoAcervo(item)) {
            System.out.println("Item não cadastrado nesta biblioteca.");
            return;
        }

        if (item.isDisponivel()) {
            System.out.println("Este item já está disponível.");
            return;
        }

        item.devolver();
        usuario.removerEmprestimo();

        System.out.println("Devolução realizada com sucesso!");
        System.out.println("Item: " + item.getTitulo());
    }

    public void listarAcervo() {
        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");
        for (int i = 0; i < quantidadeItens; i++) {
            acervo[i].exibirInformacoes();
        }
    }

    private boolean estaNoAcervo(ItemBiblioteca item) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i] == item) {
                return true;
            }
        }
        return false;
    }
}

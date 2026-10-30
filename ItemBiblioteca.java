public abstract class ItemBiblioteca {

    protected int codigo;
    protected String titulo;
    protected boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public abstract int prazoEmprestimo();

    public abstract double valorMulta();

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // A disponibilidade é alterada pelos métodos de empréstimo e devolução.
    void emprestar() {
        disponivel = false;
    }

    void devolver() {
        disponivel = true;
    }

    public void exibirInformacoes() {
        System.out.printf(
            "Código: %d | Título: %s | Prazo: %d dias | Multa: R$ %.2f | Disponível: %s%n",
            codigo, titulo, prazoEmprestimo(), valorMulta(),
            disponivel ? "Sim" : "Não"
        );
    }
}

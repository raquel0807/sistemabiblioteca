public abstract class Usuario {

    protected String nome;
    protected int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public abstract int limiteItens();

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public void adicionarEmprestimo() {
        quantidadeEmprestada++;
    }

    public void removerEmprestimo() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }
}

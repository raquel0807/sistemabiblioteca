public class Livro extends ItemBiblioteca {

    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoEmprestimo() {
        return 14;
    }

    @Override
    public double valorMulta() {
        return 0.50;
    }
}

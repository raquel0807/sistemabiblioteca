public class Revista extends ItemBiblioteca {

    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoEmprestimo() {
        return 7;
    }

    @Override
    public double valorMulta() {
        return 1.00;
    }
}

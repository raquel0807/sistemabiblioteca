public class DVD extends ItemBiblioteca {

    public DVD(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoEmprestimo() {
        return 3;
    }

    @Override
    public double valorMulta() {
        return 2.00;
    }
}

public class Main {

    public static void main(String[] args) {

        // Criação da biblioteca com capacidade para 10 itens.
        Biblioteca biblioteca = new Biblioteca(10);

        // Cadastro de livros, revistas e DVD.
        Livro livro1 = new Livro(1, "Java para Iniciantes");
        Livro livro2 = new Livro(2, "Programação Orientada a Objetos");
        Livro livro3 = new Livro(3, "Banco de Dados");
        Livro livro4 = new Livro(4, "Estrutura de Dados");

        Revista revista1 = new Revista(5, "Revista Tecnologia");
        Revista revista2 = new Revista(6, "Revista Educação");

        DVD dvd1 = new DVD(7, "Introdução à Programação");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(livro4);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);
        biblioteca.cadastrarItem(dvd1);

        // Criação dos usuários.
        Aluno aluno = new Aluno("Carlos");
        Professor professor = new Professor("Mariana");

        System.out.println("\n===== TESTE DE EMPRÉSTIMOS =====");

        // O aluno realiza três empréstimos (limite máximo).
        biblioteca.emprestar(livro1, aluno);
        biblioteca.emprestar(livro2, aluno);
        biblioteca.emprestar(livro3, aluno);

        // A quarta tentativa deve ser recusada.
        biblioteca.emprestar(revista1, aluno);

        // O professor consegue realizar empréstimos de tipos diferentes.
        biblioteca.emprestar(revista2, professor);
        biblioteca.emprestar(dvd1, professor);

        biblioteca.listarAcervo();

        System.out.println("\n===== TESTE DE DEVOLUÇÃO =====");

        // Após a devolução, o aluno pode pegar outro item.
        biblioteca.devolver(livro1, aluno);
        biblioteca.emprestar(revista1, aluno);

        biblioteca.listarAcervo();
    }
}

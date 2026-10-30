SISTEMA DE BIBLIOTECA - JAVA

Arquivos:
- ItemBiblioteca.java: classe abstrata dos itens do acervo.
- Livro.java, Revista.java e DVD.java: categorias de itens, cada uma
  com seu próprio prazo e valor de multa.
- Usuario.java: classe abstrata dos usuários.
- Aluno.java e Professor.java: usuários com limites diferentes.
- Biblioteca.java: cadastro, empréstimo, devolução e listagem.
- Main.java: cenário de teste, incluindo a nova categoria DVD.

Como executar:
1. Coloque todos os arquivos .java na mesma pasta/pacote.
2. Abra um terminal nessa pasta.
3. Compile: javac *.java
4. Execute: java Main

Requisitos: JDK instalado.

Teste de extensibilidade:
A categoria DVD foi adicionada criando apenas a classe DVD e incluindo
um objeto DVD no cenário de teste. Nenhum método existente de
ItemBiblioteca ou Biblioteca precisou ser alterado.

Para este exemplo, foram definidos prazo de 3 dias e multa de R$ 2,00
por dia para DVD, pois o enunciado não especifica esses valores.

A solução utiliza arrays de tamanho fixo e percorre ItemBiblioteca[]
em um único laço no método listarAcervo(), sem verificar o tipo do item.

Observação:
A implementação é didática: para um sistema completo, seria necessário
registrar qual usuário está associado a cada empréstimo para validar
corretamente a devolução.

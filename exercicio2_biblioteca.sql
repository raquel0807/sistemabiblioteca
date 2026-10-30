-- =====================================================
-- EXERCICIO 2 - MODELAGEM DO BANCO DE DADOS
-- Sistema de Biblioteca - PostgreSQL
-- =====================================================

-- Se desejar recriar o cenário do zero, descomente as linhas abaixo:
-- DROP TABLE IF EXISTS emprestimo;
-- DROP TABLE IF EXISTS usuario;
-- DROP TABLE IF EXISTS item;

-- 1. TABELA ITEM
CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo INTEGER NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(100),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT chk_item_tipo CHECK (tipo IN ('livro', 'revista'))
);

-- 2. TABELA USUARIO
CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,
    CONSTRAINT chk_usuario_tipo CHECK (tipo IN ('aluno', 'professor')),
    CONSTRAINT chk_limite_itens CHECK (limite_itens > 0)
);

-- 3. TABELA EMPRESTIMO
CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL REFERENCES item(id),
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) NOT NULL DEFAULT 0,
    CONSTRAINT chk_valor_multa CHECK (valor_multa >= 0)
);

-- =====================================================
-- INSERCAO DE DADOS DE TESTE
-- =====================================================

-- Itens: 4 registros
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
    (101, 'Java para Iniciantes', 'livro', 'Deitel', '10a edicao', FALSE),
    (102, 'Banco de Dados', 'livro', 'Elmasri', '7a edicao', TRUE),
    (103, 'Revista Tecnologia', 'revista', NULL, 'Edicao 25', TRUE),
    (104, 'Revista Educacao', 'revista', NULL, 'Edicao 18', TRUE);

-- Usuarios: 2 registros
INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
    ('Carlos Silva', 'aluno', 3),
    ('Mariana Souza', 'professor', 5);

-- Emprestimo em aberto
INSERT INTO emprestimo (
    item_id, usuario_id, data_retirada,
    data_devolucao_prevista, data_devolucao, valor_multa
)
VALUES (
    1, 1, DATE '2026-10-20',
    DATE '2026-11-03', NULL, 0.00
);

-- Emprestimo ja devolvido
INSERT INTO emprestimo (
    item_id, usuario_id, data_retirada,
    data_devolucao_prevista, data_devolucao, valor_multa
)
VALUES (
    2, 2, DATE '2026-10-01',
    DATE '2026-10-15', DATE '2026-10-18', 1.50
);

-- Conferencia opcional dos cadastros
SELECT * FROM item ORDER BY codigo;
SELECT * FROM usuario ORDER BY id;
SELECT * FROM emprestimo ORDER BY id;

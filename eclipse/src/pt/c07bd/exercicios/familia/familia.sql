-- Resposta dos exercicios dos slides BD05-aplicacoes-sql

-- Exercicio 1 - criar tabelas
--   Pessoa(nome, nome_da_mãe, ano_nascimento, nome_cidade_natal)
--     nome_cidade_natal → CHE Cidade
--   Cidade(nome_cidade, sigla_estado)

CREATE TABLE Cidade (
  nome_cidade VARCHAR(50),
  sigla_estado VARCHAR(2) NOT NULL,
  PRIMARY KEY(nome_cidade)
);

CREATE TABLE Pessoa (
  nome VARCHAR(50),
  nome_da_mae VARCHAR(50),
  ano_nascimento INTEGER,
  nome_cidade_natal VARCHAR(50),
  PRIMARY KEY(nome),
  FOREIGN KEY (nome_cidade_natal)
    REFERENCES Cidade(nome_cidade)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Exercicio 3a - nomes de todas as mães

SELECT DISTINCT nome_da_mae
       FROM Pessoa

-- Exercicio 3b - nomes de todas as maes com filhos maiores de 12 anos
       
SELECT DISTINCT nome_da_mae
       FROM Pessoa
       WHERE ano_nascimento < 2004
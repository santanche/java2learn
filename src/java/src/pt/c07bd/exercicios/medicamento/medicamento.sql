-- Resposta dos exercicios dos slides BD05-aplicacoes-sql

CREATE TABLE Medicamento (
  Nome_Venda VARCHAR(50),
  Composto_Ativo VARCHAR(50) NOT NULL,
  PRIMARY KEY(Nome_Venda)
);

INSERT INTO Medicamento VALUES ("QualquerSol", "Virulex");
INSERT INTO Medicamento VALUES ("OutroSol", "Virulex");
INSERT INTO Medicamento VALUES ("QualquerZona", "H1Nex");
INSERT INTO Medicamento VALUES ("OutraZona", "H1Nex");

CREATE TABLE VirusA (
  Nome_Cientifico VARCHAR(50),
  Nome_Popular VARCHAR(50) NOT NULL,
  Incubacao INTEGER,
  Medicamento_Trata VARCHAR(50),
  PRIMARY KEY(Nome_Cientifico),
  FOREIGN KEY (Medicamento_Trata)
    REFERENCES Medicamento(Nome_Venda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO VirusA VALUES ("HJN3", "Gripe Barataria", 20, "QualquerSol");
INSERT INTO VirusA VALUES ("H4N5", "Gripe Transitoria", 5, "QualquerSol");
INSERT INTO VirusA VALUES ("H7N3", "Gripe Matadora", 2, "OutraZona");

CREATE TABLE VirusB (
  Nome_Cientifico VARCHAR(50),
  Nome_Popular VARCHAR(50) NOT NULL,
  Incubacao INTEGER,
  PRIMARY KEY(Nome_Cientifico)
);

CREATE TABLE Trata (
  Nome_Cientifico_Virus VARCHAR(50),
  Medicamento_Trata VARCHAR(50),
  PRIMARY KEY(Nome_Cientifico_Virus, Medicamento_Trata),
  FOREIGN KEY (Nome_Cientifico_Virus)
    REFERENCES VirusB(Nome_Cientifico)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (Medicamento_Trata)
    REFERENCES Medicamento(Nome_Venda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO VirusB VALUES ("HJN3", "Gripe Barataria", 20);
INSERT INTO VirusB VALUES ("H4N5", "Gripe Transitoria", 5);
INSERT INTO VirusB VALUES ("H7N3", "Gripe Matadora", 2);

INSERT INTO Trata VALUES ("HJN3", "QualquerSol");
INSERT INTO Trata VALUES ("H4N5", "QualquerSol");
INSERT INTO Trata VALUES ("H7N3", "OutraZona");

-- Exercicio 4 - Compostos ativos disponiveis
SELECT DISTINCT Composto_Ativo
       FROM Medicamento;
       
-- Exercicio 5a - nome popular dos vírus tratados pelo medicamento de nome de venda W
SELECT Nome_Popular
       FROM VirusA
       WHERE Medicamento_Trata = "QualquerSol";

-- Exercicio 5b - nome popular dos vírus tratados pelo medicamento de composto ativo X
SELECT V.Nome_Popular
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda AND
             M.Composto_Ativo = "Virulex";
             
-- Exercicio 6 - nome popular dos vírus tratados pelo medicamento de composto ativo X
SELECT V.Nome_Popular
       FROM VirusB V, Trata T, Medicamento M
       WHERE V.Nome_Cientifico = T.Nome_Cientifico_Virus AND
             T.Medicamento_Trata = M.Nome_Venda AND
             M.Composto_Ativo = "Virulex";
             
-- Media de incubacao dos virus
SELECT AVG(Incubacao)
       FROM VirusB;

-- Exercicio 7a - Quantos vírus trata cada medicamento
SELECT V.Medicamento_Trata, COUNT(*)
       FROM VirusA V
       GROUP BY V.Medicamento_Trata;
       
-- Exercicio 7b - Quantos vírus trata cada composto ativo
SELECT M.Composto_Ativo, COUNT(*)
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda
       GROUP BY M.Composto_Ativo;

-- Exercicio 8a - Quantos vírus trata cada medicamento
SELECT T.Medicamento_Trata, COUNT(*)
       FROM Trata T
       GROUP BY T.Medicamento_Trata;
       
-- Exercicio 8b - Quantos vírus trata cada composto ativo
SELECT M.Composto_Ativo, COUNT(*)
       FROM Trata T, Medicamento M
       WHERE T.Medicamento_Trata = M.Nome_Venda
       GROUP BY M.Composto_Ativo;

-- Questão 7a
SELECT M.Composto_Ativo, COUNT(*)
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda AND
             V.Incubacao > 5
       GROUP BY M.Composto_Ativo;

-- Questão 7b
SELECT M.Composto_Ativo, COUNT(*) Numero_Virus
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda
       GROUP BY M.Composto_Ativo
       HAVING Numero_Virus > 5;
       
-- Extensões da Questao
SELECT M.Composto_Ativo, COUNT(*), AVG(Incubacao), MIN(Incubacao), MAX(Incubacao)
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda
       GROUP BY M.Composto_Ativo;
       
SELECT M.Composto_Ativo, COUNT(*), AVG(Incubacao), MIN(Incubacao), MAX(Incubacao)
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda AND
             V.Incubacao > 5
       GROUP BY M.Composto_Ativo;
       
SELECT M.Composto_Ativo, COUNT(*) Numero_Virus, AVG(Incubacao), MIN(Incubacao), MAX(Incubacao)
       FROM VirusA V, Medicamento M
       WHERE V.Medicamento_Trata = M.Nome_Venda
       GROUP BY M.Composto_Ativo
       HAVING Numero_Virus > 5;

-- Exemplos de SELECT aninhado feitos em sala       
       
SELECT V.Nome_Popular
       FROM VirusB V
       WHERE V.Nome_Cientifico
             IN (
          SELECT T.Nome_Cientifico_Virus FROM
                 Trata T, Medicamento M
                 WHERE T.Medicamento_Trata = M.Nome_Venda AND 
                       M.Composto_Ativo = "Virulex");

SELECT V.Nome_Popular
       FROM VirusB V
       WHERE V.Nome_Cientifico
             NOT IN (
          SELECT T.Nome_Cientifico_Virus FROM
                 Trata T, Medicamento M
                 WHERE T.Medicamento_Trata = M.Nome_Venda AND 
                       M.Composto_Ativo = "Virulex");

SELECT V.Nome_Popular
       FROM VirusB V
       WHERE EXISTS (
          SELECT M.Composto_Ativo FROM
                 Trata T, Medicamento M
                 WHERE T.Medicamento_Trata = M.Nome_Venda AND 
                       T.Nome_Cientifico_Virus = V.Nome_Cientifico);                       
                       
                      
SELECT M.Composto_Ativo
       FROM Medicamento M
       WHERE M.Nome_Venda NOT IN (
          SELECT V.Medicamento_Trata FROM
                 VirusA V
                 WHERE V.Nome_Popular = "Gripe Barataria");
                 
SELECT DISTINCT M.Composto_Ativo
       FROM Medicamento M
       WHERE M.Composto_Ativo NOT IN (
          SELECT DISTINCT M2.Composto_Ativo FROM
                 Medicamento M2, VirusA V
                 WHERE M2.Nome_Venda = V.Medicamento_Trata AND
                       V.Nome_Popular = "Gripe Barataria");
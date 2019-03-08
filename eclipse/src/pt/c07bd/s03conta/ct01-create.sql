CREATE TABLE Conta (
  numero VARCHAR(50) NOT NULL,
  nome VARCHAR(100),
  saldo DECIMAL,
  superior VARCHAR(50),
  PRIMARY KEY (numero),
  FOREIGN KEY (superior)
    REFERENCES Conta(numero)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO Conta VALUES ('1', 'Ativo', 8000, NULL);
INSERT INTO Conta VALUES ('1.1', 'Circulante', 3000, '1');
INSERT INTO Conta VALUES ('1.2', 'Imoveis', 4000, '1');
INSERT INTO Conta VALUES ('1.3', 'Veiculos', 3000, '1');

CREATE TABLE ContaHeranca (
  numero VARCHAR(50) NOT NULL,
  nome VARCHAR(100),
  saldo DECIMAL,
  superior VARCHAR(50),
  PRIMARY KEY (numero),
  FOREIGN KEY (superior)
    REFERENCES ContaHeranca(numero)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO ContaHeranca VALUES ('2', 'Passivo', NULL, NULL);
INSERT INTO ContaHeranca VALUES ('2.1', 'Contas a receber', NULL, '2');
INSERT INTO ContaHeranca VALUES ('2.2', 'Contas a pagar', 1500, '2');
INSERT INTO ContaHeranca VALUES ('2.1.1', 'Calotes', 3000, '2.1');
INSERT INTO ContaHeranca VALUES ('2.1.2', 'Longo prazo', 2100, '2.1');
INSERT INTO ContaHeranca VALUES ('2.1.3', 'Curto prazo', 700, '2.1');

select * from ContaHeranca;

SELECT SUM(saldo) FROM ContaHeranca WHERE numero LIKE '2.1%';

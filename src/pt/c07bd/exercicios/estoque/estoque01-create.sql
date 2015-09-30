CREATE TABLE Produto (
  ProdId VARCHAR(7) NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  SaldoEstoque REAL,
  PrecoUnitario REAL,
  PRIMARY KEY(ProdId)
);

INSERT INTO Produto VALUES ("0101", "Produto A", 200, 10);
INSERT INTO Produto VALUES ("0102", "Produto B", 10, 200);
INSERT INTO Produto VALUES ("0103", "Produto C", 17, 58);
INSERT INTO Produto VALUES ("0104", "Produto D", 397, 97);
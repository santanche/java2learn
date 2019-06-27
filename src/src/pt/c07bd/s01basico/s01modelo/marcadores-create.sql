CREATE TABLE Marcadores (
  Titulo VARCHAR(50) NOT NULL,
  Endereco VARCHAR(80) NOT NULL,
  Acessos INTEGER,
  Categoria VARCHAR(50) NOT NULL,
  PRIMARY KEY(Titulo),
  FOREIGN KEY(Categoria)
    REFERENCES Taxonomia(Categoria)
      ON DELETE NO ACTION
      ON UPDATE CASCADE
);

CREATE TABLE Taxonomia (
  Categoria VARCHAR(50) NOT NULL,
  Superior  VARCHAR(50),
  PRIMARY KEY(Categoria),
  FOREIGN KEY(Superior)
    REFERENCES Taxonomia(Categoria)
      ON DELETE NO ACTION
      ON UPDATE CASCADE
)




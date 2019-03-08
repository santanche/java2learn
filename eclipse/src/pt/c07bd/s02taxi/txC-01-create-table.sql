CREATE TABLE ClienteEmpresa (
  CliId VARCHAR(4) NOT NULL,
  Nome VARCHAR(80) NOT NULL,
  CNPJ VARCHAR(14) NOT NULL,
  PRIMARY KEY(CliId)
);

INSERT INTO ClienteEmpresa VALUES ('6544', 'Umbrella Corp.', '234987-0001/05');
INSERT INTO ClienteEmpresa VALUES ('6786', 'Acme', '555555-0001/07');
INSERT INTO ClienteEmpresa VALUES ('6543', 'Quincas & Co.', '322222-0001/03');

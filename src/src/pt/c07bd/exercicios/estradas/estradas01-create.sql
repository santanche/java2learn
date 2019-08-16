CREATE TABLE Cidade (
  cidadeid VARCHAR(5) NOT NULL ,
  nome VARCHAR(100) ,
  PRIMARY KEY (cidadeid) );

INSERT INTO Cidade VALUES ('SSA', 'Salvador');
INSERT INTO Cidade VALUES ('SP',  'Sao Paulo');
INSERT INTO Cidade VALUES ('RJ',  'Rio de Janeiro');
INSERT INTO Cidade VALUES ('FLO', 'Florianopolis');
INSERT INTO Cidade VALUES ('CUR', 'Curitiba');

CREATE TABLE Estrada (
  estradaid VARCHAR(5) NOT NULL ,
  nome VARCHAR(100) ,
  cidade_origem VARCHAR(5) NOT NULL ,
  cidade_destino VARCHAR(5) NOT NULL ,
  extensao_km INT ,
  PRIMARY KEY (estradaid) ,
  FOREIGN KEY (cidade_origem )
    REFERENCES Cidade (cidadeid )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (cidade_destino )
    REFERENCES Cidade (cidadeid )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO Estrada VALUES ('4545', 'Estrada 4545', 'SSA', 'RJ', 1800);
INSERT INTO Estrada VALUES ('2835', 'Estrada 2835', 'RJ', 'SP', 400);
INSERT INTO Estrada VALUES ('1012', 'Estrada 1012', 'SP', 'FLO', 600);
INSERT INTO Estrada VALUES ('1212', 'Estrada 1212', 'SP', 'CUR', 800);
INSERT INTO Estrada VALUES ('6032', 'Estrada 6032', 'FLO', 'CUR', 200);

CREATE TABLE Trajeto (
  trajetoid VARCHAR(5) NOT NULL ,
  cidade_origem VARCHAR(5) NOT NULL ,
  cidade_destino VARCHAR(5) NOT NULL ,
  PRIMARY KEY (trajetoid) ,
  FOREIGN KEY (cidade_origem )
    REFERENCES Cidade (cidadeid )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (cidade_destino )
    REFERENCES Cidade (cidadeid )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO Trajeto VALUES ('TJ001', 'SSA', 'SP');
INSERT INTO Trajeto VALUES ('TJ002', 'SSA', 'FLO');
INSERT INTO Trajeto VALUES ('TJ003', 'SP', 'CUR');
INSERT INTO Trajeto VALUES ('TJ004', 'SP', 'CUR');
INSERT INTO Trajeto VALUES ('TJ005', 'RJ', 'CUR');

CREATE TABLE Segmento (
  trajetoid VARCHAR(5) NOT NULL ,
  estradaid VARCHAR(5) NOT NULL ,
  ordem INT ,
  PRIMARY KEY (trajetoid, estradaid) ,
  FOREIGN KEY (estradaid )
    REFERENCES Estrada (estradaid )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (trajetoid )
    REFERENCES Trajeto (trajetoid )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO Segmento VALUES ('TJ001', '4545', 1);
INSERT INTO Segmento VALUES ('TJ001', '2835', 2);
INSERT INTO Segmento VALUES ('TJ002', '4545', 1);
INSERT INTO Segmento VALUES ('TJ002', '2835', 2);
INSERT INTO Segmento VALUES ('TJ002', '1012', 3);
INSERT INTO Segmento VALUES ('TJ003', '4545', 1);
INSERT INTO Segmento VALUES ('TJ003', '2835', 2);
INSERT INTO Segmento VALUES ('TJ003', '1012', 3);
INSERT INTO Segmento VALUES ('TJ004', '4545', 1);
INSERT INTO Segmento VALUES ('TJ004', '2835', 2);
INSERT INTO Segmento VALUES ('TJ004', '1012', 3);
INSERT INTO Segmento VALUES ('TJ004', '6032', 4);
INSERT INTO Segmento VALUES ('TJ005', '1012', 1);
INSERT INTO Segmento VALUES ('TJ005', '6032', 2);


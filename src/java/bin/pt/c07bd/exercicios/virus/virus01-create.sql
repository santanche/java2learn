CREATE TABLE Virus (
  virusid VARCHAR(5) NOT NULL,
  nome VARCHAR(100),
  PRIMARY KEY (virusid)
);

INSERT INTO Virus VALUES ('101', 'Quackrax');
INSERT INTO Virus VALUES ('102', 'X45');
INSERT INTO Virus VALUES ('301', 'Tubitubi');

CREATE TABLE Medicamento (
  medicamentoid VARCHAR(5) NOT NULL,
  nome VARCHAR(100),
  PRIMARY KEY (medicamentoid)
);

INSERT INTO Medicamento VALUES ('AspH', 'Aspargorim H');
INSERT INTO Medicamento VALUES ('Bon2', 'Bonergex Duplex');
INSERT INTO Medicamento VALUES ('AspM', 'Aspargorum M');
INSERT INTO Medicamento VALUES ('Bon3', 'Bonergex Triplex');
INSERT INTO Medicamento VALUES ('PinN', 'Pinicilina Ninja');

CREATE TABLE Trata (
  medicamentoid VARCHAR(5) NOT NULL,
  virusid VARCHAR(5) NOT NULL,
  PRIMARY KEY (medicamentoid, virusid),
  FOREIGN KEY(medicamentoid)
    REFERENCES Medicamento(medicamentoid)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(virusid)
    REFERENCES Virus(virusid)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

INSERT INTO Trata VALUES ('AspH', '101');
INSERT INTO Trata VALUES ('AspM', '101');
INSERT INTO Trata VALUES ('PinN', '101');
INSERT INTO Trata VALUES ('Bon2', '102');
INSERT INTO Trata VALUES ('Bon3', '102');
INSERT INTO Trata VALUES ('PinN', '102');
INSERT INTO Trata VALUES ('AspH', '301');
INSERT INTO Trata VALUES ('Bon2', '301');
INSERT INTO Trata VALUES ('Bon3', '301');
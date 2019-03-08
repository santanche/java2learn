CREATE TABLE Sequencia (
  seqid VARCHAR(5) NOT NULL,
  virustratado VARCHAR(5) NOT NULL,
  PRIMARY KEY (seqid),
  FOREIGN KEY(virustratado)
    REFERENCES Virus(virusid)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

INSERT INTO Sequencia VALUES ('001', '101');
INSERT INTO Sequencia VALUES ('002', '101');
INSERT INTO Sequencia VALUES ('003', '101');
INSERT INTO Sequencia VALUES ('004', '301');
INSERT INTO Sequencia VALUES ('005', '301');
INSERT INTO Sequencia VALUES ('006', '102');

CREATE TABLE MedicamentosSequencia (
  seqid VARCHAR(5) NOT NULL,
  ordem INTEGER NOT NULL,
  medicamentoid VARCHAR(5) NOT NULL,
  melhora INTEGER NOT NULL,
  PRIMARY KEY (seqid, ordem),
  FOREIGN KEY(seqid)
    REFERENCES Sequencia(seqid)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(medicamentoid)
    REFERENCES Medicamento(medicamentoid)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

INSERT INTO MedicamentosSequencia VALUES ('001', 1, 'AspH', 2);
INSERT INTO MedicamentosSequencia VALUES ('001', 2, 'AspM', 1);
INSERT INTO MedicamentosSequencia VALUES ('001', 3, 'PinN', 1);
INSERT INTO MedicamentosSequencia VALUES ('002', 1, 'AspM', 3);
INSERT INTO MedicamentosSequencia VALUES ('002', 2, 'AspH', 3);
INSERT INTO MedicamentosSequencia VALUES ('002', 3, 'PinN', 1);
INSERT INTO MedicamentosSequencia VALUES ('003', 1, 'PinN', 5);
INSERT INTO MedicamentosSequencia VALUES ('003', 2, 'AspH', 3);
INSERT INTO MedicamentosSequencia VALUES ('003', 3, 'AspM', 1);
INSERT INTO MedicamentosSequencia VALUES ('004', 1, 'AspH', 1);
INSERT INTO MedicamentosSequencia VALUES ('004', 2, 'Bon2', 1);
INSERT INTO MedicamentosSequencia VALUES ('004', 3, 'Bon3', 2);
INSERT INTO MedicamentosSequencia VALUES ('005', 1, 'Bon2', 7);
INSERT INTO MedicamentosSequencia VALUES ('005', 2, 'AspH', 2);
INSERT INTO MedicamentosSequencia VALUES ('005', 3, 'Bon3', 2);
INSERT INTO MedicamentosSequencia VALUES ('006', 1, 'AspH', 1);
INSERT INTO MedicamentosSequencia VALUES ('006', 2, 'Bon2', 2);
INSERT INTO MedicamentosSequencia VALUES ('006', 3, 'PinN', 2);
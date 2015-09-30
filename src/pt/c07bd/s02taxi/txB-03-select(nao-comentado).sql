SELECT M.CNH, M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH;

SELECT M.CNH, M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH AND DataHoraIn = DataHoraOut;
       
SELECT M.Placa
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH;

SELECT Fila.DataHoraIn, Motorista.Nome, Taxi.Modelo
       FROM Fila, Motorista, Taxi
       WHERE Motorista.CNH = Fila.CNH AND
             Motorista.Placa = Taxi.Placa;
       
SELECT T.Marca, T.Modelo
       FROM Taxi T, Motorista M, Fila F 
       WHERE T.Placa = M.Placa AND
             M.CNH = F.CNH;

SELECT DISTINCT T.Marca, T.Modelo
       FROM Taxi T, Motorista M, Fila F 
       WHERE T.Placa = M.Placa AND
             M.CNH = F.CNH;

SELECT DISTINCT M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH
       ORDER BY M.Nome;             

SELECT * FROM Motorista WHERE nome LIKE 'A%';

SELECT * FROM Motorista WHERE nome LIKE '%a_';

SELECT DISTINCT M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH AND
             M.Nome LIKE 'A%';
             
SELECT DISTINCT cnh, zona FROM Fila WHERE zona
       IN ('Taquaral', 'Unicamp');

SELECT DISTINCT cnh, zona FROM Fila WHERE zona
       NOT IN ('Taquaral', 'Unicamp');

SELECT * FROM Fila WHERE DataHoraIn
       BETWEEN '2002-06-05 00:00:00' AND '2002-06-06 23:59:59';             
             
SELECT Fila.zona FROM Fila;

SELECT DISTINCT Fila.Zona FROM Fila;

SELECT Zona
       FROM Fila
       GROUP BY Zona;

SELECT zona, COUNT(*)
       FROM Fila
       GROUP BY zona;

SELECT Zona, COUNT(*) Quantidade
       FROM Fila
       GROUP BY Zona;

SELECT T.Marca, T.Modelo, COUNT(*)
       FROM Taxi T, Motorista M, Fila F 
       WHERE T.Placa = M.Placa AND
             M.CNH = F.CNH
       GROUP BY T.Marca, T.Modelo;
       
SELECT Zona, KmIn, DataHoraIn FROM Fila;
       
SELECT Zona, MIN(KmIn) FROM Fila GROUP BY Zona;

SELECT Zona, MIN(DataHoraIn) FROM Fila
       WHERE DataHoraIn = DataHoraOut
       GROUP BY Zona;
	   
SELECT Zona, MAX(DataHoraIn) FROM Fila
       GROUP BY Zona;

SELECT Zona, MIN(KmIn), AVG(KmIn), MAX(DataHoraIn) FROM Fila
       GROUP BY Zona;
       
SELECT Zona, MAX(DataHoraIn) FROM Fila
       WHERE KmIn <= 5000 GROUP BY Zona;

SELECT Zona, MAX(DataHoraIn) FROM Fila GROUP BY Zona
       HAVING MAX(KmIn) <= 5000;

SELECT Zona FROM Fila GROUP BY Zona HAVING COUNT(*)>1;

CREATE VIEW QuantidadeFila AS
SELECT zona, COUNT(*) quantidade
       FROM Fila
       GROUP BY zona;
       
SELECT * FROM QuantidadeFila;

DROP VIEW QuantidadeFila;
-- CNH e Nome dos motoristas que jah estiveram e estao na fila
SELECT DISTINCT M.CNH, M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH;

-- CNH e Nome dos motoristas que estao na fila
SELECT M.CNH, M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH AND DataHoraIn = DataHoraOut;
       
-- Placa dos taxis que jah estiveram e estao na fila
SELECT M.Placa
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH;

-- Data/Hora entrada, nome e modelo dos taxis
-- que jah estiveram e estao na fila
SELECT Fila.DataHoraIn, Motorista.Nome, Taxi.Modelo
       FROM Fila, Motorista, Taxi
       WHERE Motorista.CNH = Fila.CNH AND
             Motorista.Placa = Taxi.Placa;
       
-- Marca e modelo dos taxis que jah estiveram e estao na fila
SELECT T.Marca, T.Modelo
       FROM Taxi T, Motorista M, Fila F 
       WHERE T.Placa = M.Placa AND
             M.CNH = F.CNH;

-- Marca e modelo dos taxis que jah estiveram e estao na fila 
-- (sem repeticao)
SELECT DISTINCT T.Marca, T.Modelo
       FROM Taxi T, Motorista M, Fila F 
       WHERE T.Placa = M.Placa AND
             M.CNH = F.CNH;

-- Nome dos taxistas que jah estiveram e estao na fila
-- em ordem alfabetica
SELECT DISTINCT M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH
       ORDER BY M.Nome;             

-- Operadores avancados de comparacao
-- ----------------------------------       
       
-- Motoristas cujo nome comeca com a letra A
SELECT * FROM Motorista WHERE nome LIKE 'A%';

-- Motoristas com 'a' na penultima letra
SELECT * FROM Motorista WHERE nome LIKE '%a_';

-- Nome dos motoristas que jah estiveram e estao na fila
-- e cujo nome inicia com A
SELECT DISTINCT M.Nome
       FROM Motorista M, Fila F 
       WHERE M.CNH = F.CNH AND
             M.Nome LIKE 'A%';
             
-- CNH dos motoristas que jah estiveram ou estao
-- nas filas das zonas Taquaral ou Unicamp
SELECT DISTINCT cnh, zona FROM Fila WHERE zona
       IN ('Taquaral', 'Unicamp');

-- CNH dos motoristas que nunca estiveram nem estao
-- nas filas das zonas Taquaral ou Unicamp
SELECT DISTINCT cnh, zona FROM Fila WHERE zona
       NOT IN ('Taquaral', 'Unicamp');

-- Entradas na fila entre 05 e 06/06/2002
SELECT * FROM Fila WHERE DataHoraIn
       BETWEEN '2002-06-05 00:00:00' AND '2002-06-06 23:59:59';             
             
-- Agregacao
-- ---------

-- Quais as zonas que tem ou tiveram algum taxi na fila (com repeticao)
SELECT Fila.zona FROM Fila;

-- Quais as zonas que tem ou tiveram algum taxi na fila (sem repeticao)
SELECT DISTINCT Fila.Zona FROM Fila;

-- Quais as zonas que tem ou tiveram algum taxi na fila (sem repeticao)
SELECT Zona
       FROM Fila
       GROUP BY Zona;

-- Para cada zona atendida, quantos taxis jah passaram pela fila
-- (contando com os que estao atualmente)
SELECT zona, COUNT(*)
       FROM Fila
       GROUP BY zona;

-- Quantos entradas de taxi tem/tiveram cada fila das zonas atendidas
-- (coluna COUNT com nome)       
SELECT Zona, COUNT(*) Quantidade
       FROM Fila
       GROUP BY Zona;

-- Marca e modelo dos taxis que estao/estiveram
-- em alguma fila com quantidades
SELECT T.Marca, T.Modelo, COUNT(*)
       FROM Taxi T, Motorista M, Fila F 
       WHERE T.Placa = M.Placa AND
             M.CNH = F.CNH
       GROUP BY T.Marca, T.Modelo;
       
-- Zona, quilometragem e data/hora de cada taxi que esta/esteve em uma fila
SELECT Zona, KmIn, DataHoraIn FROM Fila;
       
-- Menor quilometragem de entrada em cada zona
SELECT Zona, MIN(KmIn) FROM Fila GROUP BY Zona;

-- Zona, data e hora de entrada do proximo taxi a ser chamado em cada zona
-- (menor data/hora entrada)
SELECT Zona, MIN(DataHoraIn) FROM Fila
       WHERE DataHoraIn = DataHoraOut
       GROUP BY Zona;
	   
-- Maior data/hora de entrada para cada zona
SELECT Zona, MAX(DataHoraIn) FROM Fila
       GROUP BY Zona;

-- Zona, menor km, media km, maior data/hora para cada zona
SELECT Zona, MIN(KmIn), AVG(KmIn), MAX(DataHoraIn) FROM Fila
       GROUP BY Zona;
       
-- Maior data/hora dentre os taxis de cada zona com km <= 5000       
SELECT Zona, MAX(DataHoraIn) FROM Fila
       WHERE KmIn <= 5000 GROUP BY Zona;

-- Maior data/hora apenas para zonas cuja maxima km <= 5000
SELECT Zona, MAX(DataHoraIn) FROM Fila GROUP BY Zona
       HAVING MAX(KmIn) <= 5000;

-- Zonas que tem/tiveram mais de um taxi na fila
SELECT Zona FROM Fila GROUP BY Zona HAVING COUNT(*)>1;

-- Visoes
-- ------

-- Para cada zona atendida, quantos taxis passaram pela fila
CREATE VIEW QuantidadeFila AS
SELECT zona, COUNT(*) quantidade
       FROM Fila
       GROUP BY zona;
       
SELECT * FROM QuantidadeFila;

DROP VIEW QuantidadeFila;
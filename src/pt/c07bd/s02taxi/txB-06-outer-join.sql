-- Taxis e respectivas corridas (para taxis que fizeram corrida)
SELECT Tx.placa, Co.cliid
       FROM Taxi Tx, Corrida Co
       WHERE Tx.placa = Co.placa;

-- Taxis e respectivas corridas (para taxis que fizeram corrida)
SELECT Tx.placa, Co.cliid
       FROM Taxi Tx JOIN Corrida Co
            ON Tx.placa = Co.placa;       

-- Taxis e respectivas corridas (para taxis que fizeram corrida)
SELECT Tx.placa, Co.cliid
       FROM Taxi Tx NATURAL JOIN Corrida Co;
            
-- Taxis e respectivas corridas (para todos os taxis)
SELECT Tx.placa, Co.cliid
       FROM Taxi Tx LEFT JOIN Corrida Co
            ON Tx.placa = Co.placa;
            
-- CNH de quem esta na fila e todas as zonas
SELECT F.cnh, Z.zona
       FROM Fila F RIGHT JOIN Zona Z
            ON F.zona = Z.zona;
            
SELECT C.cliid, M.placa, M.nome
       FROM Corrida C FULL JOIN Motorista M
            ON C.placa = M.placa;
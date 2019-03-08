SELECT * FROM Zona;

SELECT * FROM Fila;

-- Zonas que receberam algum taxi na fila (sem aninhamento)
SELECT DISTINCT Z.zona
       FROM Zona Z, Fila F
       WHERE Z.zona = F.zona;

-- Zonas que receberam algum taxi na fila (com aninhamento / IN)
SELECT Z.zona
       FROM Zona Z
       WHERE Z.zona IN (SELECT DISTINCT F.zona FROM Fila F);

-- Zonas que receberam algum taxi na fila (com aninhamento / EXISTS)
SELECT Z.zona
       FROM Zona Z
       WHERE EXISTS (SELECT * FROM Fila F WHERE F.zona = Z.zona);

-- Zonas que nao receberam algum taxi na fila (com aninhamento / NOT IN)
SELECT Z.zona
       FROM Zona Z
       WHERE Z.zona NOT IN (SELECT DISTINCT F.zona FROM Fila F);

-- Zonas que nao receberam algum taxi na fila (com aninhamento / NOT EXISTS)
SELECT Z.zona
       FROM Zona Z
       WHERE NOT EXISTS (SELECT * FROM Fila F WHERE F.zona = Z.zona);

-- Taxis modelo Fiesta
SELECT T.placa, T.modelo FROM Taxi T WHERE T.modelo = 'Fiesta';

-- Nome dos clientes que andaram nos taxis modelo Fiesta (sem aninhamento)
SELECT DISTINCT Cl.nome
       FROM Cliente Cl, Corrida Co, Taxi Tx
       WHERE Cl.cliid = Co.cliid AND Co.placa = Tx.placa AND
             Tx.modelo = 'Fiesta';

-- Nome dos clientes que andaram nos taxis modelo Fiesta (com aninhamento)
SELECT DISTINCT Cl.nome
       FROM Cliente Cl, Corrida Co
       WHERE Cl.cliid = Co.cliid AND
             Co.placa IN (SELECT Tx.placa FROM Taxi Tx
                                 WHERE Tx.modelo = 'Fiesta');

-- Nome dos clientes que andaram no taxi dirigido por Bonerges
SELECT DISTINCT Cl.nome
       FROM Cliente Cl, Corrida Co
       WHERE Cl.cliid = Co.cliid AND
             Co.placa = (SELECT Tx.placa FROM Taxi Tx, Motorista Mo
                                WHERE Tx.placa = Mo.placa AND
                                      Mo.nome = 'Bonerges');

-- Taxis que entraram na fila antes da primeira entrada de Alcebiades
SELECT Mo.placa, Fi.datahorain
       FROM Motorista Mo, Fila Fi
       WHERE Mo.cnh = Fi.cnh AND
             Fi.datahorain < (SELECT MIN(F.datahorain)
                                     FROM Motorista M, Fila F
                                     WHERE M.cnh = F.cnh AND
                                           M.nome = 'Alcebiades');                                      
 
-- Quem foi o primeiro motorista a entrar em qualquer uma das filas
SELECT Mo.nome, Fi.datahorain
       FROM Motorista Mo, Fila Fi
       WHERE Mo.cnh = Fi.cnh AND
             Fi.datahorain <= ALL (SELECT datahorain FROM Fila);
             
-- Quem nao foi o primeiro motorista a entrar em qualquer uma das filas
SELECT Mo.nome, Fi.datahorain
       FROM Motorista Mo, Fila Fi
       WHERE Mo.cnh = Fi.cnh AND
             Fi.datahorain > ANY (SELECT DataHoraIn FROM Fila);
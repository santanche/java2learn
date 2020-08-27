SELECT * FROM Taxi;

SELECT Marca, Modelo FROM Taxi;

SELECT * FROM Taxi WHERE AnoFab > 2000;

-- Placas que comecem com DK
SELECT * FROM Taxi WHERE placa LIKE 'DK%';

-- Placas com '7' na penultima posicao
SELECT * FROM Taxi WHERE placa LIKE '%7_';

-- Produto cartesiano Cliente x Corrida
SELECT Cliente.CliId, Cliente.Nome, Corrida.CliId, Corrida.Placa, Corrida.DataPedido
       FROM Cliente, Corrida;

-- Join (1) Cliente x Corrida
SELECT Cliente.CliId, Cliente.Nome, Corrida.CliId, Corrida.Placa, Corrida.DataPedido
       FROM Cliente, Corrida
       WHERE Cliente.CliId = Corrida.CliId;

-- Clientes (id e nome) e respectivas corridas (placa e data do pedido)
SELECT Cliente.CliId, Cliente.Nome, Corrida.Placa, Corrida.DataPedido
       FROM Cliente, Corrida
       WHERE Cliente.CliId = Corrida.CliId;

-- Alias (apelido) com o AS
SELECT Cl.CliId, Cl.Nome, Co.Placa, Co.DataPedido
       FROM Cliente AS Cl, Corrida AS Co
       WHERE Cl.CliId = Co.CliId;
       
-- Alias sem o AS
SELECT Cl.CliId, Cl.Nome, Co.Placa, Co.DataPedido
       FROM Cliente Cl, Corrida Co
       WHERE Cl.CliId = Co.CliId;

-- Alias dos campos com o AS
SELECT Cl.CliId AS id_cliente, Cl.Nome AS nome_cliente, Co.Placa AS placa, Co.DataPedido AS data_pedido
       FROM Cliente Cl, Corrida Co
       WHERE Cl.CliId = Co.CliId;       

-- Alias dos campos sem o AS
SELECT Cl.CliId id_cliente, Cl.Nome nome_cliente, Co.Placa placa, Co.DataPedido data_pedido
       FROM Cliente Cl, Corrida Co
       WHERE Cl.CliId = Co.CliId;       
       
-- Modelo de taxi para cada corrida
SELECT Co.DataPedido, Co.Placa, T.Modelo
       FROM Corrida Co, Taxi T
       WHERE Co.Placa = T.Placa;
       
-- Modelos de taxi tomados por cada cliente
-- (estagio 1)
SELECT Cl.Nome, Co.DataPedido, Co.Placa, T.Modelo
       FROM Cliente Cl, Corrida Co, Taxi T
       WHERE Cl.CliId = Co.CliId AND Co.Placa = T.Placa;
-- (estagio 2)
SELECT DISTINCT Cl.Nome, T.Modelo
       FROM Cliente Cl, Corrida Co, Taxi T
       WHERE Cl.CliId = Co.CliId AND Co.Placa = T.Placa;
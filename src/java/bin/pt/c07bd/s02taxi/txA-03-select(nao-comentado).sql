SELECT * FROM Taxi;

SELECT Marca, Modelo FROM Taxi;

SELECT * FROM Taxi WHERE AnoFab > 2000;

SELECT Cliente.CliId, Cliente.Nome, Corrida.CliId, Corrida.Placa, Corrida.DataPedido
       FROM Cliente, Corrida;

SELECT Cliente.CliId, Cliente.Nome, Corrida.CliId, Corrida.Placa, Corrida.DataPedido
       FROM Cliente, Corrida
       WHERE Cliente.CliId = Corrida.CliId;

SELECT Cliente.CliId, Cliente.Nome, Corrida.Placa, Corrida.DataPedido
       FROM Cliente, Corrida
       WHERE Cliente.CliId = Corrida.CliId;

SELECT Cl.CliId, Cl.Nome, Co.Placa, Co.DataPedido
       FROM Cliente AS Cl, Corrida AS Co
       WHERE Cl.CliId = Co.CliId;
       
SELECT Cl.CliId, Cl.Nome, Co.Placa, Co.DataPedido
       FROM Cliente Cl, Corrida Co
       WHERE Cl.CliId = Co.CliId;

SELECT Cl.CliId AS id_cliente, Cl.Nome AS nome_cliente, Co.Placa AS placa, Co.DataPedido AS data_pedido
       FROM Cliente Cl, Corrida Co
       WHERE Cl.CliId = Co.CliId;       

SELECT Cl.CliId id_cliente, Cl.Nome nome_cliente, Co.Placa placa, Co.DataPedido data_pedido
       FROM Cliente Cl, Corrida Co
       WHERE Cl.CliId = Co.CliId;       
       
SELECT Co.DataPedido, Co.Placa, T.Modelo
       FROM Corrida Co, Taxi T
       WHERE Co.Placa = T.Placa;
       
SELECT Cl.Nome, Co.DataPedido, Co.Placa, T.Modelo
       FROM Cliente Cl, Corrida Co, Taxi T
       WHERE Cl.CliId = Co.CliId AND Co.Placa = T.Placa;
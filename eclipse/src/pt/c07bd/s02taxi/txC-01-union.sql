SELECT cliid, nome
       FROM Cliente;

SELECT cliid, nome
       FROM ClienteEmpresa;

-- Uniao de todos os clientes particulares e empresas       
SELECT cliid, nome
       FROM Cliente
UNION
SELECT cliid, nome
       FROM ClienteEmpresa;
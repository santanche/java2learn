-- Soma o saldo de contas herdeiras que iniciam com 2.1
SELECT SUM(saldo) FROM ContaHeranca WHERE numero LIKE '2.1%';

SELECT saldo FROM Conta CTSUP WHERE saldo NOT IN (
    SELECT SUM(saldo) AS soma FROM Conta WHERE superior = CTSUP.numero);
SELECT saldo FROM Conta CTSUP WHERE saldo NOT IN (
    SELECT SUM(saldo) AS soma FROM Conta WHERE superior = CTSUP.numero);
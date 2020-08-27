-- atualize a hora de entrada para o taxi cujo motorista tem CNH 452635
UPDATE Fila
       SET DataHoraOut = '2002-06-02 10:00:00'
       WHERE CNH='452635' AND DataHoraIn='2002-06-02 08:00:00';

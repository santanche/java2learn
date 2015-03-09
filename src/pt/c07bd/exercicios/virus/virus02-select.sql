-- relacao de sequencia de tratamentos (2 b)
SELECT V.nome, S.seqid, MS.ordem, M.nome, MS.melhora
       FROM Medicamento M, MedicamentosSequencia MS, Sequencia S, Virus V
       WHERE MS.medicamentoid = M.medicamentoid AND MS.seqid = S.seqid AND
             S.virustratado = V.virusid;

-- relacao de sequencia de tratamentos (2 c)
SELECT V.nome, S.seqid, MS.ordem, M.nome, MS.melhora
       FROM Medicamento M, MedicamentosSequencia MS, Sequencia S, Virus V
       WHERE MS.medicamentoid = M.medicamentoid AND MS.seqid = S.seqid AND
             S.virustratado = V.virusid
       ORDER BY S.seqid, MS.ordem;
             
-- total de melhora por sequencia de tratamento (2 d)
SELECT S.seqid, SUM(MS.melhora)
       FROM Medicamento M, MedicamentosSequencia MS, Sequencia S, Virus V
       WHERE MS.medicamentoid = M.medicamentoid AND MS.seqid = S.seqid AND
             S.virustratado = V.virusid
       GROUP BY S.seqid;

-- total de melhora por sequencia de tratamento (2 d)
SELECT S.virustratado virust, S.seqid seq, SUM(MS.melhora) totalmelhora
       FROM Medicamento M, MedicamentosSequencia MS, Sequencia S, Virus V
       WHERE MS.medicamentoid = M.medicamentoid AND MS.seqid = S.seqid AND
             S.virustratado = V.virusid
       GROUP BY S.virustratado, S.seqid;       

-- maior total de melhora por virus (2 e)
CREATE VIEW SomasSequencias AS
SELECT S.virustratado virust, SUM(MS.melhora) totalmelhora
       FROM MedicamentosSequencia MS, Sequencia S
       WHERE MS.seqid = S.seqid
       GROUP BY S.virustratado, S.seqid;       
       
SELECT * FROM SomasSequencias;       
       
SELECT virust, MAX(totalmelhora)
       FROM SomasSequencias
       GROUP BY virust;

DROP VIEW SomasSequencias;       
       
-- tratamentos com indice de melhora errado (acima de 10) (2 f)
SELECT S.seqid, S.virustratado
       FROM MedicamentosSequencia MS, Sequencia S, Virus V
       WHERE MS.seqid = S.seqid AND S.virustratado = V.virusid AND
             MS.melhora > 4
       GROUP BY S.seqid, S.virustratado;
       
-- tratamentos com indice de melhora errado (acima de 10) (2 g)
SELECT S.seqid, S.virustratado, SUM(MS.melhora)
       FROM MedicamentosSequencia MS, Sequencia S, Virus V
       WHERE MS.seqid = S.seqid AND S.virustratado = V.virusid
       GROUP BY S.seqid, S.virustratado
       HAVING SUM(MS.melhora) > 10;
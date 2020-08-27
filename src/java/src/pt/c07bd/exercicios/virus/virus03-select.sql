-- maior total de melhora por virus (2 e) usando inner
SELECT Sq.virustratado virust, SUM(MSq.melhora) totalmelhora
       FROM MedicamentosSequencia MSq, Sequencia Sq
       WHERE MSq.seqid = Sq.seqid
       GROUP BY Sq.virustratado, Sq.seqid
       HAVING SUM(MSq.melhora) >= ALL
           (SELECT SUM(MS.melhora)
                   FROM MedicamentosSequencia MS, Sequencia S
                   WHERE MS.seqid = S.seqid AND
                         S.virustratado = Sq.virustratado 
                   GROUP BY S.virustratado, S.seqid);
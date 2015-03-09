SELECT T.trajetoid, T.cidade_origem, T.cidade_destino, S.ordem, S.estradaid, E.cidade_origem, E.cidade_destino, E.extensao_km
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
       ORDER BY T.trajetoid, S.ordem;


-- Questao 3.1a

SELECT T.trajetoid, SUM(E.extensao_km)
  FROM Trajeto T, Segmento S, Estrada E
  WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
  GROUP BY T.trajetoid;
       
-- Questao 3.1b

SELECT T.trajetoid
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid AND
             T.cidade_origem <> E.cidade_origem AND S.ordem = 1;

--

-- Questao 3.1c

CREATE VIEW TrajetoNumSeg AS
SELECT T.trajetoid trajid, T.cidade_destino destino, COUNT(*) numseg
       FROM Trajeto T, Segmento S
       WHERE T.trajetoid = S.trajetoid
       GROUP BY T.trajetoid, T.cidade_destino;
       
SELECT * FROM TrajetoNumSeg;
       
SELECT T.trajid
       FROM TrajetoNumSeg T, Segmento S, Estrada E
       WHERE T.trajid = S.trajetoid AND S.estradaid = E.estradaid AND
             T.destino <> E.cidade_destino AND S.ordem = T.numseg;

DROP Table TrajetoNumSeg;

--

SELECT T.trajetoid, T.cidade_origem, T.cidade_destino, SUM(E.extensao_km)
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
       GROUP BY T.trajetoid, T.cidade_origem, T.cidade_destino;

-- Questao 3.1d

CREATE VIEW TotalTrajeto AS
SELECT T.trajetoid trajid, T.cidade_origem origem, T.cidade_destino destino, SUM(E.extensao_km) extensao
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
       GROUP BY T.trajetoid, T.cidade_origem, T.cidade_destino;

SELECT origem, destino, MIN(extensao)
       FROM TotalTrajeto
       GROUP BY origem, destino;

DROP TABLE TotalTrajeto;

-- Questao 3.1e

UPDATE Trajeto T
  SET T.extensao_km =
       (SELECT SUM(E.extensao_km)
          FROM Segmento S, Estrada E
          WHERE T.trajetoid = S.trajetoid AND
                S.estradaid = E.estradaid);
-- Relacionando as tres tabelas: Trajeto, Segmento e Estrada
SELECT T.trajetoid, T.cidade_origem, T.cidade_destino, S.ordem, S.estradaid, E.cidade_origem, E.cidade_destino, E.extensao_km
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
       ORDER BY T.trajetoid, S.ordem;


-- *** Questao 3.1a (Quilometragem de cada Trajeto)

SELECT T.trajetoid, SUM(E.extensao_km)
  FROM Trajeto T, Segmento S, Estrada E
  WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
  GROUP BY T.trajetoid;
       
-- *** Questao 3.1b (Inconsistentes: Cidade de Origem do Trajeto diferente da Cidade de Origem da primeira Estrada)

   -- (passo 1) Primeiro segmento de cada trajeto
   SELECT * FROM Segmento WHERE ordem=1;

   -- (passo 2) Associando o primeiro segmento de cada Trajeto
   SELECT *
          FROM Estrada, Segmento, Trajeto
          WHERE Estrada.estradaid = Segmento.estradaid AND Segmento.trajetoid = Trajeto.trajetoid AND
                Segmento.ordem = 1

-- (passo final)
               
SELECT T.trajetoid
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid AND
             T.cidade_origem <> E.cidade_origem AND S.ordem = 1;

-- *** Questao 3.1c (Inconsistentes: Cidade de Destino do Trajeto diferente da Cidade de Destino da ultima Estrada)

-- * (abordagem 1) Usando VIEW

  -- (passo 1a) Criando uma VIEW que computa a ordem do Estrada final de cada Trajeto (com MAX)
  CREATE VIEW TrajetoNumSeg AS
  SELECT S.trajetoid trajid, MAX(S.ordem) numseg
         FROM Segmento S
         GROUP BY S.trajetoid

  -- (passo 1b) Criando uma VIEW que computa a ordem do Estrada final de cada Trajeto (com COUNT)
  CREATE VIEW TrajetoNumSeg AS
  SELECT S.trajetoid trajid, COUNT(*) numseg
         FROM Segmento S
         GROUP BY S.trajetoid;
         
  -- (passo 2a) Criando a VIEW que define a ordem da estrada final de cada Trajeto e sua Cidade Destino (com MAX)
             
  CREATE VIEW TrajetoNumSeg AS
  SELECT T.trajetoid trajid, T.cidade_destino destino, MAX(S.ordem) numseg
         FROM Trajeto T, Segmento S
         WHERE T.trajetoid = S.trajetoid
         GROUP BY T.trajetoid;

  -- (passo 2b) Criando a VIEW que define a ordem da estrada final de cada Trajeto e sua Cidade Destino (com COUNT)
             
  CREATE VIEW TrajetoNumSeg AS
  SELECT T.trajetoid trajid, T.cidade_destino destino, COUNT(*) numseg
         FROM Trajeto T, Segmento S
         WHERE T.trajetoid = S.trajetoid
         GROUP BY T.trajetoid;
         
  -- (passo 3) Verificando o resultado da VIEW
  SELECT * FROM TrajetoNumSeg;
       
-- (passo final) Relacionando a VIEW com Segmento e Estrada
SELECT T.trajid
       FROM TrajetoNumSeg T, Segmento S, Estrada E
       WHERE T.trajid = S.trajetoid AND S.estradaid = E.estradaid AND
             T.destino <> E.cidade_destino AND S.ordem = T.numseg;

-- como se desfazer da VIEW depois do uso
DROP Table TrajetoNumSeg;
             
-- * (abordagem 2) Usando SELECT aninhado
             
SELECT T.trajetoid
  FROM Trajeto T, Segmento S1, Estrada E
  WHERE E.estradaid = S1.estradaid AND S1.trajetoid = T.trajetoid
        AND S1.ordem = (
            SELECT MAX(ordem) FROM Segmento S2 WHERE S2.trajetoid = S1.trajetoid
          )
        AND E.cidade_destino <> T.cidade_destino          

--

SELECT T.trajetoid, T.cidade_origem, T.cidade_destino, SUM(E.extensao_km)
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
       GROUP BY T.trajetoid, T.cidade_origem, T.cidade_destino;

-- *** Questao 3.1d (Trajetos de menor quilometragem entre cada origem/destino)

CREATE VIEW TotalTrajeto AS
SELECT T.trajetoid trajid, T.cidade_origem origem, T.cidade_destino destino, SUM(E.extensao_km) extensao
       FROM Trajeto T, Segmento S, Estrada E
       WHERE T.trajetoid = S.trajetoid AND S.estradaid = E.estradaid
       GROUP BY T.trajetoid, T.cidade_origem, T.cidade_destino;

SELECT origem, destino, MIN(extensao)
       FROM TotalTrajeto
       GROUP BY origem, destino;

DROP TABLE TotalTrajeto;

-- Questao 3.1e (Atualizar o campo extensao_km no Trajeto somando as quilometragens dos Segmentos)

UPDATE Trajeto T
  SET T.extensao_km =
       (SELECT SUM(E.extensao_km)
          FROM Segmento S, Estrada E
          WHERE T.trajetoid = S.trajetoid AND
                S.estradaid = E.estradaid);
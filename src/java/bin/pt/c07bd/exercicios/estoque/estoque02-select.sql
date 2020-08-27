-- Questao 3c (Atualizar preco de produtos em uma faixa)

UPDATE Produto
  SET PrecoUnitario = PrecoUnitario * 1.3
  WHERE PrecoUnitario > 50 AND PrecoUnitario < 100
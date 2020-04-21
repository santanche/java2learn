package pt.c03java.s07anotacao.s03dinheiro;

public interface RequestPrice {
   
   @UnitOfMeasure(sigla="R$", descricao="Real")
   public double getPrice();

}

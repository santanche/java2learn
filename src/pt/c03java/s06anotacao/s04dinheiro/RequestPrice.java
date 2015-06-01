package pt.c03java.s06anotacao.s04dinheiro;

public interface RequestPrice {
   
   @UnitOfMeasure(moeda=Currency.REAL, sigla="R$", descricao="Real")
   public double getPrice();

}

package pt.c03java.s06anotacao.s05dinheiro;

public interface RequestPrice {
   
   @UnitOfMeasure(Currency.REAL)
   public double getPrice();

}

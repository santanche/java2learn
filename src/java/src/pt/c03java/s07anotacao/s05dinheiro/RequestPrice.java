package pt.c03java.s07anotacao.s05dinheiro;

public interface RequestPrice {
   
   @UnitOfMeasure(Currency.REAL)
   public double getPrice();

}

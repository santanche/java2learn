package pt.c06patterns.factory.s10components.chart.exception;

public class UnsupportedNegativeNumber extends PlotException {

   private static final long serialVersionUID = -1248911490628763059L;

   public UnsupportedNegativeNumber() {
      super();
   }
   
   public UnsupportedNegativeNumber(String message) {
      super(message);
   }

}

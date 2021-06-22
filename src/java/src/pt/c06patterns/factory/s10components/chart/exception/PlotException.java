package pt.c06patterns.factory.s10components.chart.exception;

public class PlotException extends RuntimeException {

   private static final long serialVersionUID = 2727260512165247433L;

   public PlotException() {
      super();
   }
   
   public PlotException(String message) {
      super(message);
   }

}

package pt.c03java.s06wrapping.s02conversoes;

public class AppConversoesWrapping02 {

   public static void main(String[] args) {
      // criação explícita de tipo primitivo
      int x1 = 10;
      
      // criação explícita de objeto wrapper
      Integer x2 = new Integer(10);
      Integer x3 = new Integer("10");
      
      // conversão explícita tipo primitivo -> wrapper
      Integer x4 = new Integer(x1);
      
      // conversão explícita wrapper -> tipo primitivo
      int x5 = x2.intValue();
      
      // conversão implícita tipo primitivo -> wrapper
      Integer x6 = 10;
      
      // conversão implícita wrapper -> tipo primitivo
      int x7 = new Integer(10);
      int x8 = new Integer("10");
      
      // convertidos explicitamente e somados
      System.out.println("soma: " + (x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8));
   }

}

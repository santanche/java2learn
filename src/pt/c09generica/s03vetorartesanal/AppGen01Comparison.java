package pt.c09generica.s03vetorartesanal;

public class AppGen01Comparison {

   public static void main(String[] args) {
      Comparison<Integer> comp = new Comparison<Integer>();

      System.out.println(comp.greater(new Integer(5), new Integer(8)));
   }

}

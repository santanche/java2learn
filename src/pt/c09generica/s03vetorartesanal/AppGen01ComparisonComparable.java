package pt.c09generica.s03vetorartesanal;

public class AppGen01ComparisonComparable {

   public static void main(String[] args) {
      ComparisonConstrained<Integer> comp = new ComparisonConstrained<Integer>();

      System.out.println(comp.greater(new Integer(5), new Integer(8)));
   }

}

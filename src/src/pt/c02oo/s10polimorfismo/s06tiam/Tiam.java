package pt.c02oo.s10polimorfismo.s06tiam;

public class Tiam {
   
   public String first() {
      return null;
   }
   
   public String next() {
      return null;
   }
   
   public void list() {
      String element = first();
      
      while (element != null) {
         System.out.println(element);
         element = next();
      }
   }
}

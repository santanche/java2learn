package pt.c02oo.s09abstrata.s05tiam;

public abstract class Tiam {
   
   public abstract String first();
   
   public abstract String next();
   
   public void list() {
      String element = first();
      
      while (element != null) {
         System.out.println(element);
         element = next();
      }
   }
}

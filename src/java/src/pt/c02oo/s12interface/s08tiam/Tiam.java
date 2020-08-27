package pt.c02oo.s12interface.s08tiam;

public class Tiam {

   public void list(Tiai someObject) {
      String element = someObject.first();
      
      while (element != null) {
         System.out.println(element);
         element = someObject.next();
      }
   }
}

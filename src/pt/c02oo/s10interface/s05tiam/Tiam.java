package pt.c02oo.s10interface.s05tiam;

public class Tiam {

   private Tiai genericObject;
   
   public Tiam(Tiai genericObject) {
      this.genericObject = genericObject;
   }
   
   public void list() {
      String element = genericObject.first();
      
      while (element != null) {
         System.out.println(element);
         element = genericObject.next();
      }
   }
}

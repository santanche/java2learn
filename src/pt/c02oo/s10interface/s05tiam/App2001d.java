package pt.c02oo.s10interface.s05tiam;

public class App2001d {

   public static void main(String[] args) {
      Tiam abstractMachine = new Tiam(new Hal());
      
      abstractMachine.list();
   }

}

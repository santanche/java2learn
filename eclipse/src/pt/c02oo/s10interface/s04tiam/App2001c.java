package pt.c02oo.s10interface.s04tiam;

public class App2001c {

   public static void main(String[] args) {
      Tiam abstractMachine = new Tiam();
      Tiai machine = new Hal();
      
      abstractMachine.list(machine);
   }

}

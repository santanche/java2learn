package pt.c06patterns.factory.s04aquatic.console;

import pt.c06patterns.factory.s04aquatic.interfaces.ISeaAnimal;

public class FishConsole implements ISeaAnimal {
   /*   .  _
        |\/O\
        |/\_/
   */

   public String image() {
      return ".  _\n" +
             "|\\/O\\\n" +
             "|/\\_/\n";
   }
}

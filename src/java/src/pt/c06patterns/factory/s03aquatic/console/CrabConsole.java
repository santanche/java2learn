package pt.c06patterns.factory.s03aquatic.console;

import pt.c06patterns.factory.s03aquatic.interfaces.ISeaAnimal;

public class CrabConsole implements ISeaAnimal {
   /*
      o o
      | |  
    /-----\
    |     |
    \-----/
    / / \ \
   */
    
    
   public String image() {
      return "  o o\n" +
             "  | |\n" +  
             "/-----\\\n" +
             "|     |\n" +
             "\\-----/\n" +
             "/ / \\ \\\n";
   }
}

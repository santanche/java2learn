package pt.c06patterns.factory.s01aquatic;

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

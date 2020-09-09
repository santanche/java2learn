package pt.c06patterns.factory.s02aquatic;

public class CrabGUI implements ISeaAnimal {
   public String image() {
      return CrabGUI.class.getResource(".").getPath() + "crab.png";
   }
}

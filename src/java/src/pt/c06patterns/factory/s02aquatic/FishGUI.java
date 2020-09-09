package pt.c06patterns.factory.s02aquatic;

public class FishGUI implements ISeaAnimal {
   public String image() {
      return FishGUI.class.getResource(".").getPath() + "fish.png";
   }
}

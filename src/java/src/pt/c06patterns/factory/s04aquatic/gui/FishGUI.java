package pt.c06patterns.factory.s04aquatic.gui;

import pt.c06patterns.factory.s04aquatic.interfaces.ISeaAnimal;

public class FishGUI implements ISeaAnimal {
   public String image() {
      return FishGUI.class.getResource(".").getPath() + "fish.png";
   }
}

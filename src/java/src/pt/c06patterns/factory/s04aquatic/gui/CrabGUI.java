package pt.c06patterns.factory.s04aquatic.gui;

import pt.c06patterns.factory.s04aquatic.interfaces.ISeaAnimal;

public class CrabGUI implements ISeaAnimal {
   public String image() {
      return CrabGUI.class.getResource(".").getPath() + "crab.png";
   }
}

package pt.c06patterns.factory.s03aquatic.gui;

import pt.c06patterns.factory.s03aquatic.interfaces.ISeaAnimal;

public class CrabGUI implements ISeaAnimal {
   public String image() {
      return CrabGUI.class.getResource(".").getPath() + "crab.png";
   }
}

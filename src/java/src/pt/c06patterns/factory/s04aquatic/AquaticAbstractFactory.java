package pt.c06patterns.factory.s04aquatic;

import pt.c06patterns.factory.s04aquatic.console.AquaticFactoryConsole;
import pt.c06patterns.factory.s04aquatic.gui.AquaticFactoryGUI;
import pt.c06patterns.factory.s04aquatic.interfaces.IAquaticFactory;

public class AquaticAbstractFactory {
   public static IAquaticFactory createFactory(String type) {
      IAquaticFactory aquaticFactory = null;
      if (type.equals("console"))
         aquaticFactory = new AquaticFactoryConsole();
      else if (type.equals("gui"))
         aquaticFactory = new AquaticFactoryGUI();
      return aquaticFactory;
   }
}

package pt.c06patterns.factory.s03aquatic.gui;

import pt.c06patterns.factory.s03aquatic.interfaces.IAquaticFactory;
import pt.c06patterns.factory.s03aquatic.interfaces.IFishTank;
import pt.c06patterns.factory.s03aquatic.interfaces.ISeaAnimal;

public class AquaticFactoryGUI implements IAquaticFactory {
   public ISeaAnimal createSeaAnimal(String type) {
      ISeaAnimal seaAnimal = null;
      if (type.equals("fish"))
         seaAnimal = new FishGUI();
      else if (type.equals("crab"))
         seaAnimal = new CrabGUI();
      return seaAnimal;
   }
   
   public IFishTank createFishTank(String type) {
      IFishTank fishTank = null;
      if (type.equals("standard"))
         fishTank = new FishTankGUI();
      return fishTank;
   }
}

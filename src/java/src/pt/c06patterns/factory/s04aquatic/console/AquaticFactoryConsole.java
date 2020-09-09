package pt.c06patterns.factory.s04aquatic.console;

import pt.c06patterns.factory.s04aquatic.interfaces.IAquaticFactory;
import pt.c06patterns.factory.s04aquatic.interfaces.IFishTank;
import pt.c06patterns.factory.s04aquatic.interfaces.ISeaAnimal;

public class AquaticFactoryConsole implements IAquaticFactory {
   public ISeaAnimal createSeaAnimal(String type) {
      ISeaAnimal seaAnimal = null;
      if (type.equals("fish"))
         seaAnimal = new FishConsole();
      else if (type.equals("crab"))
         seaAnimal = new CrabConsole();
      return seaAnimal;
   }
   
   public IFishTank createFishTank(String type) {
      IFishTank fishTank = null;
      if (type.equals("standard"))
         fishTank = new FishTankConsole();
      return fishTank;
   }
}

package pt.c06patterns.factory.s03aquatic.console;

import java.util.ArrayList;

import pt.c06patterns.factory.s03aquatic.interfaces.IFishTank;
import pt.c06patterns.factory.s03aquatic.interfaces.ISeaAnimal;

public class FishTankConsole implements IFishTank {
   ArrayList<ISeaAnimal> aquaticList = new ArrayList<ISeaAnimal>(); 

   public void addSeaAnimal(ISeaAnimal aquatic) {
      aquaticList.add(aquatic);
   }

   public void showFishTank() {
      System.out.println("+-----------------+");
      System.out.println("|                 |");
      for (ISeaAnimal aq: aquaticList)
         System.out.println(aq.image());
      System.out.println("|                 |");
      System.out.println("+-----------------+");
   }

}

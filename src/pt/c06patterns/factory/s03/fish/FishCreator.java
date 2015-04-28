package pt.c06patterns.factory.s03.fish;

import pt.c06patterns.factory.s03.interfaces.Aquatic;
import pt.c06patterns.factory.s03.interfaces.AquaticCreator;

public class FishCreator implements AquaticCreator {

   public Aquatic createAquatic() {
      return new Fish();
  }
   
}

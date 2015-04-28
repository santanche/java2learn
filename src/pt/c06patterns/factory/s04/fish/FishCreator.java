package pt.c06patterns.factory.s04.fish;

import pt.c06patterns.factory.s04.interfaces.Aquatic;
import pt.c06patterns.factory.s04.interfaces.AquaticCreator;
import pt.c06patterns.factory.s04.interfaces.AquaticType;

public class FishCreator implements AquaticCreator {

   public Aquatic createAquatic(AquaticType type) {
      return new Fish(type);
  }
   
}

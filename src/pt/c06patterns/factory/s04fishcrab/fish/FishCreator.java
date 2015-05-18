package pt.c06patterns.factory.s04fishcrab.fish;

import pt.c06patterns.factory.s04fishcrab.interfaces.Aquatic;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticCreator;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticType;

public class FishCreator implements AquaticCreator {

   public Aquatic createAquatic(AquaticType type) {
      return new Fish(type);
  }
   
}

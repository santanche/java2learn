package pt.c06patterns.factory.s03fishcrab.fish;

import pt.c06patterns.factory.s03fishcrab.interfaces.Aquatic;
import pt.c06patterns.factory.s03fishcrab.interfaces.AquaticCreator;

public class FishCreator implements AquaticCreator {

   public Aquatic createAquatic() {
      return new Fish();
  }
   
}

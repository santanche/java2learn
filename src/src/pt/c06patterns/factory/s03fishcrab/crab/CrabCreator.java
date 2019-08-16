package pt.c06patterns.factory.s03fishcrab.crab;

import pt.c06patterns.factory.s03fishcrab.interfaces.Aquatic;
import pt.c06patterns.factory.s03fishcrab.interfaces.AquaticCreator;

public class CrabCreator implements AquaticCreator {

   public Aquatic createAquatic() {
        return new Crab();
    }

}

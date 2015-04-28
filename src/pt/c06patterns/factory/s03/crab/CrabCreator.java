package pt.c06patterns.factory.s03.crab;

import pt.c06patterns.factory.s03.interfaces.Aquatic;
import pt.c06patterns.factory.s03.interfaces.AquaticCreator;

public class CrabCreator implements AquaticCreator {

   public Aquatic createAquatic() {
        return new Crab();
    }

}

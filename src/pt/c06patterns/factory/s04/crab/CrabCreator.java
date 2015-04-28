package pt.c06patterns.factory.s04.crab;

import pt.c06patterns.factory.s04.interfaces.Aquatic;
import pt.c06patterns.factory.s04.interfaces.AquaticCreator;
import pt.c06patterns.factory.s04.interfaces.AquaticType;

public class CrabCreator implements AquaticCreator {

   public Aquatic createAquatic(AquaticType type) {
        return new Crab(type);
    }

}

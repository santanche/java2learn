package pt.c06patterns.factory.s04fishcrab.crab;

import pt.c06patterns.factory.s04fishcrab.interfaces.Aquatic;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticCreator;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticType;

public class CrabCreator implements AquaticCreator {

   public Aquatic createAquatic(AquaticType type) {
        return new Crab(type);
    }

}

package pt.c06patterns.factory.s06fishcrab.crab;

import pt.c06patterns.factory.s06fishcrab.AbstractFactory;
import pt.c06patterns.factory.s06fishcrab.Aquarium;
import pt.c06patterns.factory.s06fishcrab.Aquatic;

public class CrabFactory extends AbstractFactory
{
    public Aquatic createAquatic()
    {
        return new Crab();
    }

    public Aquarium createAquarium()
    {
        return new CrabAquarium();
    }
}

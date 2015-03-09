package pt.c06patterns.factory.s04.crab;

import pt.c06patterns.factory.s04.AbstractFactory;
import pt.c06patterns.factory.s04.Aquarium;
import pt.c06patterns.factory.s04.Aquatic;

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

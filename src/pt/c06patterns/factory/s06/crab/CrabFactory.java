package pt.c06patterns.factory.s06.crab;

import pt.c06patterns.factory.s06.AbstractFactory;
import pt.c06patterns.factory.s06.Aquarium;
import pt.c06patterns.factory.s06.Aquatic;

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

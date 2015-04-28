package pt.c06patterns.factory.s05.crab;

import pt.c06patterns.factory.s05.AbstractFactory;
import pt.c06patterns.factory.s05.Aquarium;
import pt.c06patterns.factory.s05.Aquatic;

public class CrabFactory implements AbstractFactory
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

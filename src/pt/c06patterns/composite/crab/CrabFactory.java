package pt.c06patterns.composite.crab;

import pt.c06patterns.composite.AbstractFactory;
import pt.c06patterns.composite.Aquarium;
import pt.c06patterns.composite.Aquatic;

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

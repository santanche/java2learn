package pt.c06patterns.factory.s03.crab;

import pt.c06patterns.factory.s03.AbstractFactory;
import pt.c06patterns.factory.s03.Aquarium;
import pt.c06patterns.factory.s03.Aquatic;

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

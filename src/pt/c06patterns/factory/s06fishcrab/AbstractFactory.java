package pt.c06patterns.factory.s06fishcrab;

import pt.c06patterns.factory.s06fishcrab.crab.CrabFactory;
import pt.c06patterns.factory.s06fishcrab.fish.FishFactory;

public abstract class AbstractFactory
{
    public abstract Aquatic createAquatic();
    public abstract Aquarium createAquarium();
    
    public static AbstractFactory createFactory(String id)
    {
        AbstractFactory factory = null;
        if (id.equalsIgnoreCase("fish"))
            factory = new FishFactory();
        else if (id.equalsIgnoreCase("crab"))
            factory = new CrabFactory();
        return factory;
    }
}

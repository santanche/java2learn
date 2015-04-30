package pt.c06patterns.composite;

import pt.c06patterns.composite.crab.CrabFactory;
import pt.c06patterns.composite.fish.FishFactory;
import pt.c06patterns.composite.group.MixFactory;

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
        else if (id.equalsIgnoreCase("group"))
            factory = new MixFactory();
        return factory;
    }
}

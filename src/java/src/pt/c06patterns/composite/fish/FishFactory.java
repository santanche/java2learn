package pt.c06patterns.composite.fish;

import pt.c06patterns.composite.AbstractFactory;
import pt.c06patterns.composite.Aquarium;
import pt.c06patterns.composite.Aquatic;

public class FishFactory extends AbstractFactory
{
    public Aquatic createAquatic()
    {
        return new Fish();
    }

    public Aquarium createAquarium()
    {
        return new FishAquarium();
    }
}

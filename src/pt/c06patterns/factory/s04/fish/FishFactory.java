package pt.c06patterns.factory.s04.fish;

import pt.c06patterns.factory.s04.AbstractFactory;
import pt.c06patterns.factory.s04.Aquarium;
import pt.c06patterns.factory.s04.Aquatic;

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

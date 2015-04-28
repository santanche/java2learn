package pt.c06patterns.factory.s06.fish;

import pt.c06patterns.factory.s06.AbstractFactory;
import pt.c06patterns.factory.s06.Aquarium;
import pt.c06patterns.factory.s06.Aquatic;

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

package pt.c06patterns.factory.s05.fish;

import pt.c06patterns.factory.s05.AbstractFactory;
import pt.c06patterns.factory.s05.Aquarium;
import pt.c06patterns.factory.s05.Aquatic;

public class FishFactory implements AbstractFactory
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

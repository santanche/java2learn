package pt.c06patterns.factory.s06fishcrab.fish;

import pt.c06patterns.factory.s06fishcrab.AbstractFactory;
import pt.c06patterns.factory.s06fishcrab.Aquarium;
import pt.c06patterns.factory.s06fishcrab.Aquatic;

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

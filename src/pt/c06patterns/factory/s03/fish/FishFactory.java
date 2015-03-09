package pt.c06patterns.factory.s03.fish;

import pt.c06patterns.factory.s03.AbstractFactory;
import pt.c06patterns.factory.s03.Aquarium;
import pt.c06patterns.factory.s03.Aquatic;

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

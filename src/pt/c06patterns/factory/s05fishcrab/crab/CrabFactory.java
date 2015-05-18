package pt.c06patterns.factory.s05fishcrab.crab;

import pt.c06patterns.factory.s05fishcrab.AbstractFactory;
import pt.c06patterns.factory.s05fishcrab.Aquarium;
import pt.c06patterns.factory.s05fishcrab.Aquatic;

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

package pt.c06patterns.factory.s05fishcrab.fish;

import pt.c06patterns.factory.s05fishcrab.AbstractFactory;
import pt.c06patterns.factory.s05fishcrab.Aquarium;
import pt.c06patterns.factory.s05fishcrab.Aquatic;

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

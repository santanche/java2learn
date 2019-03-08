package pt.c06patterns.factory.s05fishcrab;

import pt.c06patterns.factory.s05fishcrab.crab.CrabFactory;
import pt.c06patterns.factory.s05fishcrab.fish.FishFactory;

public class FishTank3
{
    public static void drawFishTank(AbstractFactory factory)
    {
        Aquatic theAquatic = factory.createAquatic();
        Aquarium theAquarium = factory.createAquarium();
        
        System.out.println(theAquarium.topAquarium());
        System.out.println(theAquatic.aquaticImage());
        System.out.println(theAquarium.bottomAquarium());
    }
    
    public static void main(String[] args)
    {
        AbstractFactory factory = null;
        if (args != null && args.length > 0) {
            if (args[0].equalsIgnoreCase("fish"))
                factory = new FishFactory();
            else
                factory = new CrabFactory();
            if (factory != null)
                drawFishTank(factory);
        }
            
    }
}

package pt.c06patterns.factory.s04fishcrab;

import pt.c06patterns.factory.s04fishcrab.crab.CrabCreator;
import pt.c06patterns.factory.s04fishcrab.fish.FishCreator;
import pt.c06patterns.factory.s04fishcrab.interfaces.Aquatic;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticCreator;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticType;

public class FishTank4
{
    public static void drawFishTank(Aquatic theAquatic)
    {
        System.out.println("+-----------------+");
        System.out.println("|                 |");
        System.out.println(theAquatic.aquaticImage());       
        System.out.println("|                 |");
        System.out.println("+-----------------+");
    }
    
    public static void main(String[] args)
    {
        AquaticCreator theAquaticCreator = null;
        if (args != null && args.length > 0) {
            if (args[0].equalsIgnoreCase("fish"))
                theAquaticCreator = new FishCreator();
            else
                theAquaticCreator = new CrabCreator();

            if (theAquaticCreator != null) {
               AquaticType type = AquaticType.SWEET;
               if (args[1].equalsIgnoreCase("marine"))
                  type = AquaticType.SWEET;

                Aquatic theAquatic = theAquaticCreator.createAquatic(type);
                drawFishTank(theAquatic);
            }
        }
            
    }
}

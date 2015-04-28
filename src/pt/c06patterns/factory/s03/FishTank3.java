package pt.c06patterns.factory.s03;

import pt.c06patterns.factory.s03.crab.CrabCreator;
import pt.c06patterns.factory.s03.fish.FishCreator;
import pt.c06patterns.factory.s03.interfaces.Aquatic;
import pt.c06patterns.factory.s03.interfaces.AquaticCreator;

public class FishTank3
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
                Aquatic theAquatic = theAquaticCreator.createAquatic();
                drawFishTank(theAquatic);
            }
        }
            
    }
}

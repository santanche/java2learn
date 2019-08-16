package pt.c06patterns.factory.s02fishcrab;

public class FishTank2
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
        Aquatic theAquatic = null;
        if (args != null && args.length > 0) {
            if (args[0].equalsIgnoreCase("fish"))
                theAquatic = new Fish();
            else
                theAquatic = new Crab();
            if (theAquatic != null)
                drawFishTank(theAquatic);
        }
            
    }
}

package pt.c06patterns.factory.s01fishcrab;

public class FishTank1
{
    public static void drawFishTank(String tipo)
    {
        System.out.println("+-----------------+");
        System.out.println("|                 |");
        if (tipo.equalsIgnoreCase("fish")) {
            Fish theFish = new Fish();
            System.out.println(theFish.fishImage());
        } else if (tipo.equalsIgnoreCase("crab")) {
            Crab theCrab = new Crab();
            System.out.println(theCrab.crabImage());
        }            
        System.out.println("|                 |");
        System.out.println("+-----------------+");
    }
    
    public static void main(String[] args)
    {
        if (args != null && args.length > 0)
            drawFishTank(args[0]);
    }
}

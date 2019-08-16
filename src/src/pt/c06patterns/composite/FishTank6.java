package pt.c06patterns.composite;

public class FishTank6
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
            factory = AbstractFactory.createFactory(args[0]);
            if (factory != null)
                drawFishTank(factory);
        }
            
    }
}

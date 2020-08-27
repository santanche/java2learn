package pt.c06patterns.factory.s03fishcrab.crab;

import pt.c06patterns.factory.s03fishcrab.interfaces.Aquatic;

public class Crab implements Aquatic
{
    /*
       o o
       | |  
     /-----\
     |     |
     \-----/
     / / \ \
     */
    
    
    public String aquaticImage()
    {
        return "  o o\n" +
               "  | |\n" +  
               "/-----\\\n" +
               "|     |\n" +
               "\\-----/\n" +
               "/ / \\ \\\n";
    }
}

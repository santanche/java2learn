package pt.c06patterns.factory.s04.crab;

import pt.c06patterns.factory.s04.Aquatic;

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

package pt.c06patterns.factory.s05fishcrab.crab;

import pt.c06patterns.factory.s05fishcrab.Aquatic;

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

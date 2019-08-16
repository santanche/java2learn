package pt.c06patterns.composite.fish;

import pt.c06patterns.composite.Aquatic;

public class Fish implements Aquatic
{
    /*   .  _
         |\/O\
         |/\_/
     */

    public String aquaticImage()
    {
        return ".  _\n" +
               "|\\/O\\\n" +
               "|/\\_/\n";
    }

}

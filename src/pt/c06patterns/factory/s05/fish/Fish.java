package pt.c06patterns.factory.s05.fish;

import pt.c06patterns.factory.s05.Aquatic;

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

package pt.c06patterns.factory.s04.fish;

import pt.c06patterns.factory.s04.Aquatic;

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

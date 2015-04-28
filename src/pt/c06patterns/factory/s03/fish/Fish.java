package pt.c06patterns.factory.s03.fish;

import pt.c06patterns.factory.s03.interfaces.Aquatic;

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

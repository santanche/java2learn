package pt.c06patterns.factory.s05fishcrab.fish;

import pt.c06patterns.factory.s05fishcrab.Aquatic;

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

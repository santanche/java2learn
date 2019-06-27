package pt.c06patterns.factory.s05fishcrab.crab;

import pt.c06patterns.factory.s05fishcrab.Aquarium;

public class CrabAquarium implements Aquarium
{
    public String topAquarium()
    {
        return "/================\\\n" +
               "||              ||";
    }


    public String bottomAquarium()
    {
        return "||              ||\n" + 
               "\\=================/";
    }
}

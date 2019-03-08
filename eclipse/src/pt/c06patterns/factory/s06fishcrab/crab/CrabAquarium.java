package pt.c06patterns.factory.s06fishcrab.crab;

import pt.c06patterns.factory.s06fishcrab.Aquarium;

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

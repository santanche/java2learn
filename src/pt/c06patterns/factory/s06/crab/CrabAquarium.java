package pt.c06patterns.factory.s06.crab;

import pt.c06patterns.factory.s06.Aquarium;

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

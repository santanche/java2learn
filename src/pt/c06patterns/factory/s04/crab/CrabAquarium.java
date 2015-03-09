package pt.c06patterns.factory.s04.crab;

import pt.c06patterns.factory.s04.Aquarium;

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

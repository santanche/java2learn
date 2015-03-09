package pt.c06patterns.factory.s03.crab;

import pt.c06patterns.factory.s03.Aquarium;

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

package pt.c06patterns.factory.s04.fish;

import pt.c06patterns.factory.s04.Aquarium;

public class FishAquarium implements Aquarium
{
    public String topAquarium()
    {
        return "+----------------+\n" +
               "|                |";
    }


    public String bottomAquarium()
    {
        return "|                |\n" + 
               "+----------------+";
    }
}

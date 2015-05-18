package pt.c06patterns.factory.s06fishcrab.fish;

import pt.c06patterns.factory.s06fishcrab.Aquarium;

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

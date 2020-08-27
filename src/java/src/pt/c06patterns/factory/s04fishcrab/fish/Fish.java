package pt.c06patterns.factory.s04fishcrab.fish;

import pt.c06patterns.factory.s04fishcrab.interfaces.Aquatic;
import pt.c06patterns.factory.s04fishcrab.interfaces.AquaticType;

public class Fish implements Aquatic
{
    /*   .  _
         |\/O\
         |/\_/
     */

   private AquaticType type;
   
   public Fish(AquaticType type) {
      this.type = type;
   }
  
    public String aquaticImage()
    {
       String image =
               ".  _\n" +
               "|\\/O\\\n" +
               "|/\\_/\n";
      
      if (type == AquaticType.SWEET)
        image = 
              ".  _\n" +
              "|\\/*\\\n" +
              "|/\\_/\n";
      
      return image;
    }

}

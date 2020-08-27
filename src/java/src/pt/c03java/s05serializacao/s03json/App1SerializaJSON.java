package pt.c03java.s05serializacao.s03json;

import java.text.SimpleDateFormat;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import pt.c03java.s05serializacao.s00bastiao.Bastiao;

public class App1SerializaJSON
{
   public static void main(String args[])
    {
       Genson genson = new GensonBuilder()
         .useDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
         .useIndentation(true)
         .useConstructorWithArguments(false)
       .create();

       Bastiao theBastian = new Bastiao(1, "acordado", "Asdrubal");
        
       String json = genson.serialize(theBastian);

       System.out.println(json);
    }
}

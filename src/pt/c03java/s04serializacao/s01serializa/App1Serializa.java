package pt.c03java.s04serializacao.s01serializa;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import pt.c03java.s04serializacao.s00bastiao.Bastiao;

public class App1Serializa
{
   public static void main(String args[])
    {
        Bastiao theBastian = new Bastiao(1, "acordado", "Asdrubal");
        
        try {
            ObjectOutputStream encoder = new ObjectOutputStream(
                    new FileOutputStream(Bastiao.DIRETORIO + "thebastian.bin") );
            encoder.writeObject(theBastian);
            encoder.close();
            
            System.out.println("Objeto gravado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

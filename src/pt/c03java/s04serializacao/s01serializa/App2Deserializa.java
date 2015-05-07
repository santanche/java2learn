package pt.c03java.s04serializacao.s01serializa;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import pt.c03java.s04serializacao.s00bastiao.Bastiao;

public class App2Deserializa
{
    public static void main(String args[])
    {
        Bastiao theBastian;
        
        try {
           ObjectInputStream decoder = new ObjectInputStream(
                            new FileInputStream(Bastiao.DIRETORIO + "thebastian.bin") );

            theBastian = (Bastiao)decoder.readObject();
            decoder.close();

            theBastian.aparece();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package pt.c03java.s04serializacao.s02serializaxml;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import pt.c03java.s04serializacao.s00bastiao.Bastiao;

public class App1SerializaXML
{
   public static void main(String args[])
    {
        Bastiao theBastian = new Bastiao(1, "acordado", "Asdrubal");
        
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(Bastiao.DIRETORIO + "thebastian.xml") ) );
            encoder.writeObject(theBastian);
            encoder.close();
            
            System.out.println("Objeto gravado com sucesso!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

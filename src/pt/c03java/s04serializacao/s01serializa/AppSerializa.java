package pt.c03java.s04serializacao.s01serializa;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AppSerializa
{
    public static void main(String args[])
    {
        Bastiao theBastian = new Bastiao(1, "acordado", "Asdrubal");
        
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream("thebastian.xml") ) );
            encoder.writeObject(theBastian);
            encoder.close(); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

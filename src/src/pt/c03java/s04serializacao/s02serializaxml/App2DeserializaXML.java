package pt.c03java.s04serializacao.s02serializaxml;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import pt.c03java.s04serializacao.s00bastiao.Bastiao;

public class App2DeserializaXML
{
    public static void main(String args[])
    {
        Bastiao theBastian;
        
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(Bastiao.DIRETORIO + "thebastian.xml") ) );

            theBastian = (Bastiao)decoder.readObject();
            decoder.close();

            theBastian.aparece();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

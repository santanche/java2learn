package pt.c06patterns.iterator;

import java.util.Enumeration;
import java.util.Vector;

public class ListIterator
{
    public static void main(String args[])
    {
        Vector<String> lista = new Vector<String>();
        lista.addElement("Asdrubal");
        lista.addElement("Doriana");
        lista.addElement("Quincas");
        lista.addElement("Melissa");
        
        Enumeration<String> elementos = lista.elements();
        
        while (elementos.hasMoreElements()) {
            String unidade = elementos.nextElement();
            System.out.println(unidade);
        }
    }
}

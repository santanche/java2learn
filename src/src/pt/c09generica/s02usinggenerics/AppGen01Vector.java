package pt.c09generica.s02usinggenerics;

import java.util.Scanner;
import java.util.Vector;

public class AppGen01Vector
{
    public static void main(String args[])
    {
        Vector lista = new Vector();
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite um numero: ");
        String entrada = teclado.nextLine();
        while (!entrada.equalsIgnoreCase("fim")) {
            Integer numero = new Integer(entrada);
            lista.add(numero);
            
            System.out.print("Digite outro numero: ");
            entrada = teclado.nextLine();
        }
        
        int cumulativa = 0;
        for (int pos = 0; pos < lista.size(); pos++) {
            // o cast eh necessario pois a lista guarda qualquer objeto            
            Integer n = (Integer)lista.get(pos);
            
            cumulativa += n.intValue();
            System.out.println("Soma cumulativa: " + cumulativa);
        }
    }
}

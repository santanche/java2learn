package pt.c09generica.s02usinggenerics;

import java.util.Scanner;
import java.util.Vector;

public class AppGen02Vector
{
    public static void main(String args[])
    {
        Vector<Integer> lista = new Vector<Integer>();
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite um numero: ");
        String entrada = teclado.nextLine();
        while (!entrada.equalsIgnoreCase("fim")) {
            Integer numero = new Integer(entrada);
            // <erro> String numero = entrada;
            lista.add(numero);
            
            System.out.print("Digite outro numero: ");
            entrada = teclado.nextLine();
        }
        
        int cumulativa = 0;
        for (int pos = 0; pos < lista.size(); pos++) {
            // com o generics o Java infere o tipo de retorno
            Integer n = lista.get(pos);
            
            cumulativa += n.intValue();
            System.out.println("Soma cumulativa: " + cumulativa);
        }
    }
}

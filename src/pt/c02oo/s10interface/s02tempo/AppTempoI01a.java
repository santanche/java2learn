package pt.c02oo.s10interface.s02tempo;

import java.util.Scanner;

public class AppTempoI01a
{
    public static void main(String[] args)
    {
    	Scanner teclado = new Scanner(System.in);
    	
    	Tempo oTempo = null;
        
        System.out.print("Digite o tipo de objeto: ");
        String tipo = teclado.nextLine();
        
        System.out.print("Digite o primeiro valor: ");
        int v1 = Integer.parseInt(teclado.nextLine());
        System.out.print("Digite o segundo valor: ");
        int v2 = Integer.parseInt(teclado.nextLine());
        System.out.print("Digite o terceiro valor: ");
        int v3 = Integer.parseInt(teclado.nextLine());
        
        if (tipo.equalsIgnoreCase("data"))
            oTempo = new Data(v1, v2, v3);
        else if (tipo.equalsIgnoreCase("horario"))
            oTempo = new Horario(v1, v2, v3);
        
        dadosTempo(oTempo);
    }

    public static void dadosTempo(Tempo oTempo)
    {
        if (oTempo == null)
            System.out.println("Tipo inexistente");
        else {
            System.out.println("Tempo formatado: " +
                               oTempo.toString());
            
            System.out.println("Tempo em segundos: " +
                               oTempo.quantidade());
        }
    }
}

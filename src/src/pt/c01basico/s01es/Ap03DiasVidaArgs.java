package pt.c01basico.s01es;
import java.util.Scanner;

public class Ap03DiasVidaArgs
{
    public static void main(String args[])
    {
    	String sidade = null;
    	
    	if (args.length > 0)
    		sidade = args[0];
    	else {
    	    System.out.print("Digite sua idade: ");
	        Scanner teclado = new Scanner(System.in);
	        sidade = teclado.nextLine();
    	}
    	
        int idade = Integer.parseInt(sidade);
        
        int diasVida = idade * 365;
        System.out.println("Voce tem " + diasVida + " dias de vida");
    }
}

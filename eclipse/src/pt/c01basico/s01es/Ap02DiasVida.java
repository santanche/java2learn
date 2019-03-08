package pt.c01basico.s01es;
import java.util.Scanner;

public class Ap02DiasVida
{
    public static void main(String args[])
    {
	    System.out.print("Digite sua idade: ");
        Scanner teclado = new Scanner(System.in);
        String sidade = teclado.nextLine();

        int idade = Integer.parseInt(sidade);
        int diasVida = idade * 365;

        System.out.println("Voce tem " + diasVida + " dias de vida");
    }
}

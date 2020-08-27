package pt.c01basico.s02progtr;
import java.util.Scanner;

public class Ap02DiasVida
{
    public static void main(String args[])
    {
	     System.out.print("Digite sua idade: ");
        Scanner teclado = new Scanner(System.in);
        String sidade = teclado.nextLine();
        int idade = Integer.parseInt(sidade);
        
        if (idade >= 18)
           System.out.println("Você é maior de idade");
        else
           System.out.println("Você não é maior de idade");
    }
}

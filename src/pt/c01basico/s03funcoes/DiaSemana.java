package pt.c01basico.s03funcoes;
import java.util.Scanner;


public class DiaSemana
{
	static int converte(String entrada)
	{
		int resultado = 0;
		if (entrada.equalsIgnoreCase("domingo"))
			resultado = 1;
		else if (entrada.equalsIgnoreCase("segunda"))
			resultado = 2;
		else if (entrada.equalsIgnoreCase("terca"))
			resultado = 3;
		return resultado;
	}
	
	public static void main(String args[])
	{
        System.out.print("Digite o dia da semana (ateh terca!!!): ");
        
        Scanner teclado = new Scanner(System.in);
        String entrada = teclado.nextLine();
        
        System.out.println("Convertido: " + converte(entrada));
	}
}

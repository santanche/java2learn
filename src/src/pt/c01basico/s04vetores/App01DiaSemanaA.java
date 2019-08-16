package pt.c01basico.s04vetores;
import java.util.Scanner;


public class App01DiaSemanaA
{
	static int converte(String entrada)
	{
        String nomeDia[] = {"domingo", "segunda", "terca"};
        
		int resultado = 0;
		for (int i = 0; i < nomeDia.length; i++)
			if (entrada.equalsIgnoreCase(nomeDia[i]))
				resultado = i + 1;
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

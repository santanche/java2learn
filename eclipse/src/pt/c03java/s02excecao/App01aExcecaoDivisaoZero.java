package pt.c03java.s02excecao;

import java.util.Scanner;

public class App01aExcecaoDivisaoZero
{
    public static void main(String args[])
    {
        Scanner teclado = new Scanner(System.in);
        
		boolean concluido = false;
		
		while (!concluido) {
			System.out.print("Digite o numerador: ");
			String xs = teclado.nextLine();
			
			System.out.print("Digite o denominador: ");
			String ys = teclado.nextLine();
			
			int x = Integer.parseInt(xs),
				y = Integer.parseInt(ys);
			
			try {
				int divisao = x / y;
				System.out.println("Resultado da divisao: " + divisao);
				concluido = true;
			} catch (ArithmeticException erro) {
				System.err.println("Erro: " + erro.getMessage());
				System.out.println("Valores invalidos, digite novamente");
			}
        }

		teclado.close();
	}
}

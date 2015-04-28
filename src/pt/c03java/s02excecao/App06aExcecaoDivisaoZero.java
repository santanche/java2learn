package pt.c03java.s02excecao;

import java.util.Scanner;

public class App06aExcecaoDivisaoZero
{
    public static void main(String args[])
    {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite o numerador: ");
        String xs = teclado.nextLine();
        
        System.out.print("Digite o denominador: ");
        String ys = teclado.nextLine();
        
        teclado.close();

        int x = Integer.parseInt(xs),
            y = Integer.parseInt(ys);
        
		try {
			int divisao = divide(x, y);
			System.out.println("Resultado da divisao: " + divisao);
		} catch (Exception erro) {
			erro.printStackTrace();
		}
    }
    
    public static int divide(int x, int y)  throws ArithmeticException, DivisaoInutil
    {
        int divisao;
		
		if (y == 1)
			throw new DivisaoInutil("Esta divisao eh inutil");

        divisao = x / y;
            
        return divisao;
    }
}

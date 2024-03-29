package pt.c03java.s03excecao.s01basico;

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
    			System.out.println("Ocorreu um erro, veja o rastreamento a seguir:");
    		   erro.printStackTrace();
    		}
    }
    
    // criando uma nova exception
    public static int divide(int x, int y)  throws ArithmeticException, DivisaoInutil
    {
        int divisao;
		
    		if (y == 1)
    			throw new DivisaoInutil("Esta divisao eh inutil");

        divisao = x / y;
            
        return divisao;
    }
}

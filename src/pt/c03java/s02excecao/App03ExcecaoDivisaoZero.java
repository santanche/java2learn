package pt.c03java.s02excecao;

import java.util.Scanner;

public class App03ExcecaoDivisaoZero
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
        } catch (ArithmeticException erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
    }
    
    public static int divide(int x, int y)
    {
        int divisao;

        divisao = x / y;
            
        return divisao;
    }
}

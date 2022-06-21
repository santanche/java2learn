package pt.c03java.s03excecao.s01basico;

import java.util.Scanner;

public class App01aExcecaoDivisaoZero
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
        
        // try/catch básico para a divisão
        try {
            int divisao = x / y;
            System.out.println("Resultado da divisao: " + divisao);
        } catch (ArithmeticException erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
    }
}

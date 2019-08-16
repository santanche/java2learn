package pt.c03java.s02excecao;

import java.util.Scanner;

public class App02bExcecaoDivisaoZero
{
    public static void main(String args[])
    {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite o numerador: ");
        String xs = teclado.nextLine();
        
        System.out.print("Digite o denominador: ");
        String ys = teclado.nextLine();
        
        teclado.close();

        try {
            int x = Integer.parseInt(xs),
                y = Integer.parseInt(ys);
        
            int divisao = x / y;
            System.out.println("Resultado da divisao: " + divisao);
        } catch (Exception erro) {
            System.err.println("Erro: " + erro.getMessage());
        }

}
}

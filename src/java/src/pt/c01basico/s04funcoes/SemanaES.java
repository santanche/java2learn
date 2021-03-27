package pt.c01basico.s04funcoes;
import java.util.Scanner;

public class SemanaES
{
   static String semanaTexto(int diaSemana) {
      String texto = "invalido";
      switch (diaSemana) {
        case 1 : texto = "domingo"; break;
        case 2 : texto = "segunda"; break;
        case 3 : texto = "terca";   break;
        case 4 : texto = "quarta";  break;
        case 5 : texto = "quinta";  break;
        case 6 : texto = "sexta";   break;
        case 7 : texto = "sabado";
      }
      return texto;
   }
	
	public static void main(String args[])
	{
        System.out.print("Digite o dia da semana: ");
        
        Scanner teclado = new Scanner(System.in);
        int entrada = Integer.parseInt(teclado.nextLine());
        
        System.out.println("Convertido: " + semanaTexto(entrada));
	}
}

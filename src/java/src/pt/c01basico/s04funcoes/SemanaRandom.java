package pt.c01basico.s04funcoes;
import java.util.Random;

public class SemanaRandom
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
	   Random rand = new Random();
	   int diaSemana = rand.nextInt(7) + 1;
	   System.out.println("Dia da semana: " + semanaTexto(diaSemana));
	}
}

package pt.c02oo.s06heranca.s03bastiao;

import java.util.Scanner;

public class AppBastiaoH01
{

  public static void main(String argumentos[])
  {
    Bastiao theBastian = null;
    Perfeito thePerfect = null;
    Monstro theMonster = null;

    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite o tipo de Bastiao: ");
    String tipo = teclado.nextLine();
    
    if (tipo.equalsIgnoreCase("Bastiao"))
        theBastian = new Bastiao(1, "acordado", "Bastiao");
    else if (tipo.equalsIgnoreCase("Perfeito"))
        thePerfect = new Perfeito(1, "acordado", "Perfeito", "normal");
    else if (tipo.equalsIgnoreCase("Monstro"))
        theMonster = new Monstro(1, "acordado", "Monstro");

    System.out.println();

    if (theBastian == null && thePerfect == null && theMonster == null)
      System.out.println("Este bastiao nao existe");
    else if (theBastian != null) {
      theBastian.aparece();
      System.out.println();
      theBastian.cresce();
      System.out.println();
      theBastian.cresce();
    }
    else if (thePerfect != null) {
      thePerfect.aparece();
      System.out.println();
      thePerfect.cresce();
      System.out.println();
      thePerfect.cresce();
      System.out.println();
      thePerfect.mudaSituacao();
      System.out.println();
      thePerfect.mudaSituacao();
    }
    else if (theMonster != null) {
      theMonster.aparece();
      System.out.println();
      for (int i = 1; i <= 4; i++) {
        theMonster.cresce();
        System.out.println();
      }
    }
  }

}

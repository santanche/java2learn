package pt.c02oo.s06heranca.s02bastiao;

import java.util.Scanner;

public class AppBastiaoH02
{

  public static void main(String argumentos[])
  {
    Bastiao theBastian = null;
    Monstro theMonster = null;

    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite o tipo de Bastiao: ");
    String tipo = teclado.nextLine();
    
    if (tipo.equalsIgnoreCase("Bastiao"))
        theBastian = new Bastiao(1, "acordado", "Bastiao");
    else if (tipo.equalsIgnoreCase("Monstro"))
        theMonster = new Monstro(1, "acordado", "Monstro", true);

    System.out.println();

    if (theBastian == null && theMonster == null)
      System.out.println("Este bastiao nao existe");
    else if (theBastian != null) {
      theBastian.aparece();
      System.out.println();
      theBastian.cresce();
      System.out.println();
      theBastian.cresce();
    }
    else if (theMonster != null) {
      theMonster.aparece();
      System.out.println();
      theMonster.cresce();
      System.out.println();
      theMonster.cresce();
      System.out.println();
      theMonster.cutuca();
    }
  }

}

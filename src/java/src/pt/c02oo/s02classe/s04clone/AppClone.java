package pt.c02oo.s02classe.s04clone;

public class AppClone {

   public static void main(String[] args) {
      NomeCompleto nc1 = new NomeCompleto("Asdrubal", "Oliveira");
      System.out.println("=== Caso 1");
      NomeCompleto nc2 = nc1;
      nc2.setSobrenome("Montequio");
      System.out.println(nc1);
      System.out.println(nc2);
      
      NomeCompleto nc3 = new NomeCompleto("Asdrubal", "Oliveira");
      System.out.println("=== Caso 2");
      NomeCompleto nc4 = new NomeCompleto(nc3.getNome(), nc3.getSobrenome());
      nc3.setSobrenome("Montequio");
      System.out.println(nc3);
      System.out.println(nc4);

      NomeCompleto nc5 = new NomeCompleto("Asdrubal", "Oliveira");
      System.out.println("=== Caso 3");
      NomeCompleto nc6 = nc5.clone();
      nc5.setSobrenome("Montequio");
      System.out.println(nc5);
      System.out.println(nc6);
   }

}

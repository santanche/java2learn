package pt.c01basico.s02string;

public class Ap01String {

   public static void main(String[] args) {
      String nome = "Asdrubal",
            sobrenome = " Silva";

     String nomeCompleto = nome + sobrenome;
     System.out.println("Nome completo: " + nomeCompleto);
     System.out.println("Tamanho: " + nomeCompleto.length());
     System.out.println("Igual a Quincas: " + nomeCompleto.equals("Quincas"));
     System.out.println("Igual a ASDRUBAL SILVA: " + nomeCompleto.equalsIgnoreCase("ASDRUBAL SILVA"));
   }

}
